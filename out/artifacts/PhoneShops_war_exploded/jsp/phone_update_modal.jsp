<%--
  Created by IntelliJ IDEA.
  User: 9470
  Date: 2018/8/26
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="/phone/update" method="post" class="form-horizontal">
    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">更新手机信息</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="phoneId" class="col-sm-2 control-label">序号</label>
                        <div class="col-sm-10">
                            <input type="text" id="phoneId" class="form-control" name="id" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phonename" class="col-sm-2 control-label">手机名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phonename" placeholder="手机名" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phoneprice" class="col-sm-2 control-label">价格</label>
                        <div class="col-sm-10">
                            <input type="number" step="0.001" class="form-control" id="phoneprice" placeholder="价格" name="price">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phonebrand" class="col-sm-2 control-label">品牌</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phonebrand" placeholder="品牌" name="brand">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div><input type="submit" class="btn btn-primary" value="提交更新"></div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>