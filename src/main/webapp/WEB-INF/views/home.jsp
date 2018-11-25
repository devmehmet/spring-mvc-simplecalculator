<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#Hesapla").click(function() {
			calculate();
		});
	});

	function calculate() {
		if(isFieldsValid()){
			hideErrorFields();
			$.ajax({
				url : 'calculate',
				type : "post",
				data : $('form[name=calculator]').serialize(),
				success : function(data) {
					if (data.validated == false) {
						$("[name=result]").html("");
						var errorMessages = data.errorMessages;
						for ( var err in errorMessages) {
							var formErrorField = $("[name=err-" + err + "]");
							if (formErrorField.hasClass("d-none")) {
								formErrorField.removeClass("d-none");
								formErrorField.html(errorMessages[err]);
							}
						}
					} else {					
						$("[name=result]").html(data.result);
					}
				}
			});
		}		
	}

	function hideErrorFields() {
		if (!$("[name=err-firstNumber]").hasClass("d-none")) {
			$("[name=err-firstNumber]").addClass("d-none");
		}
		if (!$("[name=err-secondNumber]").hasClass("d-none")) {
			$("[name=err-secondNumber]").addClass("d-none");
		}
		if (!$("[name=err-operation]").hasClass("d-none")) {
			$("[name=err-operation]").addClass("d-none");
		}
	}

	function isPressedNumbersValid(evt) {
		var value = $(evt.target).val();
		value += evt.key;
		var regex = /^(-?[0-9]+\.?[0-9]*?|-)$/; //regex for validate "123."
		//var regex = /^-?\d+(.\d+)?$/; actual regex
		var isValid = regex.test(value);
		return isValid;
	}

	function isFieldsValid() {
		var valid = true;
		if ($("[name=firstNumber]").val() == "") {
			if ($("[name=err-firstNumber]").hasClass("d-none")) {
				$("[name=err-firstNumber]").removeClass("d-none");
				$("[name=err-firstNumber]").html("* 1. sayı boş bırakılamaz.");
			}
			valid = false;
		}
		if ($("[name=secondNumber]").val() == "") {
			if ($("[name=err-secondNumber]").hasClass("d-none")) {
				$("[name=err-secondNumber]").removeClass("d-none");
				$("[name=err-secondNumber]").html("* 2. sayı boş bırakılamaz.");
			}
			valid = false;
		}

		if ($("[name=operation]").val() == "") {
			if ($("[name=err-operation]").hasClass("d-none")) {
				$("[name=err-operation]").removeClass("d-none");
				$("[name=err-operation]").html("* İşlem alanı boş bırakılamaz.");
				valid = false;
			}
		}
		return valid;
	}
</script>

<title>Basit Hesaplama Aracı</title>
</head>

<body class="bg-light">
	<div class="container mt-3">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<h2>Basit Hesaplama Aracı</h2>

				<form name="calculator" method="post" action="calculate">
					<table>
						<tr>
							<td style="width: 70px">1. Sayı:</td>
							<td><input class="form-control-sm" type="text"
								name="firstNumber" path="fistNumber" required="required"
								pattern="-?\d+(.\d+)?" onkeypress="return isPressedNumbersValid(event)" /></td>
							<td><a name="err-firstNumber"
								class="text-danger ml-1 d-none">Error</a></td>
						</tr>
						<tr>
							<td>2. Sayı:</td>
							<td><input class="form-control-sm" type="text"
								name="secondNumber" path="secondNumber" required="required"
								pattern="-?\d+(.\d+)?" onkeypress="return isPressedNumbersValid(event)" /></td>
							<td><a name="err-secondNumber"
								class="text-danger ml-1 d-none">Error</a></td>
						</tr>
						<tr>
							<td>İşlem:</td>
							<td><select name="operation" class="form-control-sm"
								path="operation">
									<option value="addition" label="Toplama">Toplama</option>
									<option value="subtraction" label="Çıkarma">Çıkarma</option>
									<option value="multiplication" label="Çarpma">Çarpma</option>
									<option value="division" label="Bölme">Bölme</option>
							</select></td>
							<td><a name="err-operation" class="text-danger ml-1 d-none">Error</a>
							</td>
						</tr>
						<tr>
							<td><button type="button" id="Hesapla"
									class="btn btn-primary mt-2">Hesapla</button></td>
							<td><b class="ml-1">Sonuç:</b> <label name="result"></label></td>
							<td></td>
						</tr>
					</table>
				</form>
			</div>

		</div>
	</div>

</body>
</html>
