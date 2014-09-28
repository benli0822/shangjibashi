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
    <div id="pad-wrapper" class="new-user">
        <div class="row header">
            <div class="col-md-12">
                <h3><spring:message code="label.title1"/></h3>
            </div>
        </div>


        <div class="row form-wrapper">
            <!-- left column -->
            <div class="col-md-9 with-sidebar">
                <div class="container">
                    <form class="new_dish_form">
                        <div class="col-md-12 field-box">
                            <label>Name:</label>
                            <input class="form-control" type="text"/>
                        </div>
                        <div class="col-md-12 field-box">
                            <label>Type:</label>

                            <div class="ui-select span5">
                                <select>
                                    <option value="AK">Alaska</option>
                                    <option value="HI">Hawaii</option>
                                    <option value="CA">California</option>
                                    <option value="NV">Nevada</option>
                                    <option value="OR">Oregon</option>
                                    <option value="WA">Washington</option>
                                    <option value="AZ">Arizona</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>

                <!-- side right column -->
                <div class="col-md-3 form-sidebar pull-right">
                    <div class="btn-group toggle-inputs hidden-tablet">
                        <button class="glow left active" data-input="normal">NORMAL INPUTS</button>
                        <button class="glow right" data-input="inline">INLINE INPUTS</button>
                    </div>
                    <div class="alert alert-info hidden-tablet">
                        <i class="icon-lightbulb pull-left"></i>
                        Click above to see difference between inline and normal inputs on a form
                    </div>
                    <h6>Sidebar text for instructions</h6>

                    <p>Add multiple users at once</p>

                    <p>Choose one of the following file types:</p>
                    <ul>
                        <li><a href="#">Upload a vCard file</a></li>
                        <li><a href="#">Import from a CSV file</a></li>
                        <li><a href="#">Import from an Excel file</a></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>