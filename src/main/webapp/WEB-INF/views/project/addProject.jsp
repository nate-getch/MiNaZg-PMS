<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Add New Project</h2>
<hr/>
<div class="half-width">
    <form:form modelAttribute="newProject" cssClass="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <form:input  path="name" class="form-control" id="name"  />
                <div class="has-error">
                    <form:errors path="name" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Description:</label>
            <div class="col-sm-10">
                <form:textarea path="description" class="form-control" id="description" />
                <div class="has-error">
                    <form:errors path="description" />
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="status">Status:</label>
            <div class="col-sm-10">
                <form:select class="form-control" path="status" items="${statusTypes}"
                             itemLabel="StatusType"
                             itemValue="StatusType"/>
                <div class="has-error">
                    <form:errors path="status" />
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="dateStart">Start Date:</label>
            <div class="col-sm-10">
                <%--<form:input  path="dateStart" class="form-control" id="dateStart"  />--%>
                    <div class='input-group date' id='datetimepicker1'>
                        <form:input path="dateStart" class="form-control" />
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                <div class="has-error">
                    <form:errors path="dateStart" />
                </div>
                <div class='col-sm-6'>

                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <form:hidden path="id" id="id"/>
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form:form>
</div>

<script type="text/javascript">
    // # ref http://eonasdan.github.io/bootstrap-datetimepicker/Options/
    $("#datetimepicker1").datetimepicker({
        format: 'mm/DD/YYYY',
        widgetPositioning: {
            horizontal: 'auto',
            vertical: 'bottom'
        }
    });

</script>