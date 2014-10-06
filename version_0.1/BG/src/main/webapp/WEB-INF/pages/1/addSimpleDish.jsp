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
            <div class="col-md-8 column">
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
                </form>
            </div>
        </div>
    </div>
</div>

<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {

        // select2 plugin for select elements
        $(".select2").select2({
            placeholder: "<spring:message code="add.selectType"/>"
        });

    });
</script>