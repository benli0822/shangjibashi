<%--
  Created by IntelliJ IDEA.
  User: benli
  Date: 24/09/14
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="content">
    <div id="pad-wrapper" class="gallery">
        <div class="row header">
            <div class="col-md-12">
                <h3><spring:message code="dishes.title1"/></h3>
            </div>
        </div>

        <!-- gallery wrapper -->
        <div class="gallery-wrapper">
            <div class="row gallery-row">
                <!-- single image -->
                <div class="col-md-3 img-container">
                    <div class="img-box">
                            <span class="icon edit">
                                <a data-toggle="modal" href="#myModal"><i class="gallery-edit"></i></a>
                            </span>
                            <span class="icon trash">
                                <i class="gallery-trash"></i>
                            </span>
                        <img src="img/gallery3.jpg" class="img-responsive"/>

                        <p class="title">
                            Beach pic title
                        </p>
                    </div>
                </div>

                <!-- new image button -->
                <div class="col-md-3 new-img">
                    <a data-toggle="modal" href="#myModal">
                        <img src="img/new-gallery-img.png" class="img-responsive"/>
                    </a>
                </div>
            </div>
        </div>

        <!-- blank state -->
        <div class="no-gallery">
            <div class="row header">
                <div class="col-md-12">
                    <h3><spring:message code="dishes.title1" /></h3>
                </div>
            </div>
            <div class="center">
                <img src="img/no-img-gallery.png">
                <h6><spring:message code="dishes.noItemTitle" /></h6>

                <p><spring:message code="dishes.noItemContent" /></p>
                <a data-toggle="modal" href="#myModal" class="btn-glow primary"><spring:message code="dishes.addItemButton"/></a>
            </div>
        </div>
        <!-- end blank state -->
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
                            <input type="file" id="input1" class="pull-left" />
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
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
