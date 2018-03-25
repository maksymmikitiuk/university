(function($) {
  "use strict";


  /*==================================================================
  [ Validate ]*/
  var inputFirst = $('.validate-input-1 .input100');
  var inputSecond = $('.validate-input-2 .input100');
  var inputThird = $('.validate-input-3 .input100');

  $('.first-stage').on('submit', function() {
    var check = true;

    for (var i = 0; i < inputFirst.length; i++) {
      if (validate(inputFirst[i]) == false) {
        showValidate(inputFirst[i]);
        check = false;
      }
    }

    if (check) {
      $.post("forgot_password", function(data) {
        if (!$.isBlank(reset_code == '200')) {
          $('.first-stage').hide();
          $('.second-stage').show();
        } else {
          swal({
            title: 'Error',
            text: "You entered an invalid email.",
            type: 'error',
            confirmButtonColor: '#827ffe',
            confirmButtonText: 'OK',
            confirmButtonClass: 'login100-form-btn'
          });
        }
      });
    } else {
      return check;
    }
  });

  $('.second-stage').on('submit', function() {
    var check = true;

    for (var i = 0; i < inputSecond.length; i++) {
      if (validate(inputSecond[i]) == false) {
        showValidate(inputSecond[i]);
        check = false;
      }
    }

    if (check) {
      $.post("check_code", function(data) {
        if (!$.isBlank(reset_code == '200')) {
          $('.second-stage').hide();
          $('.third-stage').show();
        }else {
          swal({
            title: 'Error',
            text: "You entered an incorrect the reset code.",
            type: 'error',
            confirmButtonColor: '#827ffe',
            confirmButtonText: 'OK',
            confirmButtonClass: 'login100-form-btn'
          });
        }
      });
    } else {
      return check;
    }
  });

  $('.third-stage').on('submit', function() {
    var check = true;

    for (var i = 0; i < inputThird.length; i++) {
      if (validate(inputSecond[i]) == false) {
        showValidate(inputSecond[i]);
        check = false;
      }
    }

    if (check) {
      $.post("check_code", function(data) {
        if (!$.isBlank(reset_code == '200')) {
          swal({
            title: 'Success',
            text: "Password changed successfully.",
            type: 'success',
            confirmButtonColor: '#827ffe',
            confirmButtonText: 'OK',
            confirmButtonClass: 'login100-form-btn'
          });
        }else {
          swal({
            title: 'Error',
            text: "Password was not changed.",
            type: 'error',
            confirmButtonColor: '#827ffe',
            confirmButtonText: 'OK',
            confirmButtonClass: 'login100-form-btn'
          });
        }
      });
    } else {
      return check;
    }
  });

  $('.first-stage .input100').each(function() {
    $(this).focus(function() {
      hideValidate(this);
    });
  });

  $('.second-stage .input100').each(function() {
    $(this).focus(function() {
      hideValidate(this);
    });
  });

  $('.third-stage .input100').each(function() {
    $(this).focus(function() {
      hideValidate(this);
    });
  });

  function validate(input) {
    if ($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
      return false;
    }
  }

  function showValidate(input) {
    var thisAlert = $(input).parent();

    $(thisAlert).addClass('alert-validate');
  }

  function hideValidate(input) {
    var thisAlert = $(input).parent();

    $(thisAlert).removeClass('alert-validate');
  }
})(jQuery);
