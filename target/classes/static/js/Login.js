function modifyState() {
    $(document).ready(function(){
        var state = $(":submit").prop("disabled");//被禁止时为true
        var counter = 0;
        $(":checkbox").each(function() {
            if($(this).prop("checked")) {//选中时为true
                counter++;
            }
        })
        if(counter == 2){
            state=false;
        }else{
            state=true;
        }
        $(":submit").prop("disabled",state);
    })
}
$(document).ready(function(){
    $(":text").keyup(function(){
        var value = $(":text").val();
        if(value.length==0){
            $("#usernameState").text("");
        }else{
            $.ajax({
                url: "Ajax/CheckWeightData",
                type: "POST",
                context: $("#usernameState"),
                data: {username:value},
                dataType: "json",
                cache: false,
                success: function(result){
                    if(result){
                        $(this).text("用户名已占用");
                    }else{
                        $(this).text("用户名可用");
                    }
                }
            })
        }
    })
})

