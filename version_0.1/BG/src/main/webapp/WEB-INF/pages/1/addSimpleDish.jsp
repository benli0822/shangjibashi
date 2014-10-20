<%--
  Created by IntelliJ IDEA.
  User: benli
  Date: 28/09/14
  Time: 12:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="content">
    <div id="pad-wrapper" class="form-page">
        <div class="row header">
            <div class="col-md-12">
                <h3><spring:message code="add.title"/></h3>
            </div>
        </div>


        <div class="row form-wrapper">
            <!-- left column -->
            <div class="col-md-7 column">
                <form>
                    <div class="field-box">
                        <label><spring:message code="add.name"/></label>

                        <div class="col-md-7">
                            <input class="form-control" type="text"/>
                        </div>
                    </div>
                    <div class="field-box">
                        <label><spring:message code="add.type"/></label>

                        <div class="col-md-7">
                            <select style="width:250px" class="select2">
                                <option></option>
                                <option value="AK">Alaska</option>
                            </select>
                        </div>
                    </div>
                    <div class="field-box">
                        <label><spring:message code="add.description"/></label>

                        <div class="col-md-7">
                            <textarea class="form-control" rows="4"></textarea>
                        </div>
                    </div>
                    <div class="field-box">
                        <label><spring:message code="add.doNeedSetTime"/></label>

                        <div class="col-md-8">
                            <label class="radio">
                                <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                <spring:message code="add.yes"/>
                            </label>
                            <label class="radio">
                                <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                                <spring:message code="add.no"/>
                            </label>
                        </div>
                    </div>
                    <div class="field-box">
                        <label><spring:message code="add.time"/> </label>

                        <div class="col-md-8">
                            <div class="col-md-5">
                                <input type="text" value="03/29/2013" class="form-control input-datepicker"/>
                            </div>
                            <div class="col-md-1"><spring:message code="add.to"/></div>
                            <div class="col-md-5">
                                <input type="text" value="03/29/2013" class="form-control input-datepicker"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <!-- right column -->
            <div class="col-md-5 column pull-right">
                <div class="field-box">
                    <label><spring:message code="add.image"/> </label>
                    <br/><br/>
                    <div class="col-md-8 new-img">
                        <a data-toggle="modal" href="#myModal">
                            <img src="img/new-gallery-img.png" class="img-responsive"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <a class="btn btn-success"><spring:message code="add.submit"/></a>
        <a class="btn btn-default"><spring:message code="add.return"/></a>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Add new image</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="input1" class="col-lg-2 control-label">Image:</label>

                        <div class="col-lg-10">
                            <input type="file" id="input1" class="pull-left"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="input1" class="col-lg-2 control-label">Description:</label>

                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputPassword1" placeholder="Description">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {

        // select2 plugin for select elements
        $(".select2").select2({
            placeholder: "<spring:message code="add.selectType"/>"
        });

        // datepicker plugin
        $('.input-datepicker').datepicker().on('changeDate', function (ev) {
            $(this).datepicker('hide');
        });

    });
</script>