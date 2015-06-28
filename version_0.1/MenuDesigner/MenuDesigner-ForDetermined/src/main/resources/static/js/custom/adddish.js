/**
 * Created by benli on 01/01/15.
 */
Dropzone.autoDiscover = false;

jQuery(function ($) {

    try {
        $(".dropzone").dropzone({
            url: "/upload",
            autoProcessQueue: true,
            uploadMultiple: true,
            paramName: "file", // The name that will be used to transfer the file
            maxFilesize: 200000, // MB

            parallelUploads: 100,
            maxFiles: 100,

            success: function (file, response) {
                console.log(response, file);

                var items = [];
                $.each(response, function (key, val) {
                    items.push("<li id='" + val.name + "'><input class=\"hidden\" value=\"" + val.id + "\" name=\"image\"/></li>");
                });
                $("#imageResList").append(items);
            },

            addRemoveLinks: true,
            removedfile: function (file) {
                var name = file.name;
                $.ajax({
                    type: 'POST',
                    url: '/delete',
                    data: "id=" + name,
                    dataType: 'html'
                });
                console.log(file.name);

                $("#imageResList").children().each(function () {
                    if ($(this).attr("id") === file.name) {
                        $(this).remove();
                    }
                });

                var _ref;
                return (_ref = file.previewElement) != null ? _ref.parentNode.removeChild(file.previewElement) : void 0;
            },
            dictDefaultMessage: '<span class="bigger-150 bolder"><i class="icon-caret-right red"></i> Drop files</span> to upload \
                            <span class="smaller-80 grey">(or click)</span> <br /> \
                            <i class="upload-icon icon-cloud-upload blue icon-3x"></i>'
            ,
            dictResponseError: 'Error while uploading file!',

            //change the previewTemplate to use Bootstrap progress bars
            previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>"
        });
    } catch (e) {
        alert('Dropzone.js does not support older browsers!' + e);
    }

    $('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {
        $(this).prev().focus();
    });
    $('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function () {
        $(this).next().focus();
    });
    $('#timepicker1').timepicker({
        minuteStep: 1,
        showSeconds: true,
        showMeridian: false
    }).next().on(ace.click_event, function () {
        $(this).prev().focus();
    });

    $('#timepicker2').timepicker({
        minuteStep: 1,
        showSeconds: true,
        showMeridian: false
    }).next().on(ace.click_event, function () {
        $(this).prev().focus();
    });

    $('[data-rel=tooltip]').tooltip({container: 'body'});
    $('[data-rel=popover]').popover({container: 'body'});

    //we could just set the data-provide="tag" of the element inside HTML, but IE8 fails!
    var tag_input = $('#form-field-tags');
    if (!( /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()))) {
        tag_input.tag(
            {
                placeholder: tag_input.attr('placeholder'),
                //enable typeahead by specifying the source array
                source: ace.variable_US_STATES //defined in ace.js >> ace.enable_search_ahead
            }
        );
    }
    else {
        //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
        tag_input.after('<textarea id="' + tag_input.attr('id') + '" name="' + tag_input.attr('name') + '" rows="3">' + tag_input.val() + '</textarea>').remove();
        //$('#form-field-tags').autosize({append: "\n"});
    }

    $('#form-field-switch-date').change(function () {
        $("#id-date-range-picker-1").attr('disabled', !$(this).is(':checked'));
    });


    $('#form-field-switch-time').change(function () {
        $("#timepicker1").attr('disabled', !$(this).is(':checked'));
        $("#timepicker2").attr('disabled', !$(this).is(':checked'));
    });

    $('#submit-btn').click(function () {
        $('#validation-form').submit();
    });

    $('#reset-btn').click(function () {
        $('#validation-form')[0].reset();
    })

});