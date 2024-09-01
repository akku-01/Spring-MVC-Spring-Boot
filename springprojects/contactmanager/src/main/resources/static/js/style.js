setTimeout(function() {
    document.querySelector('.alert').remove();
}, 5000);

const toggleSidebar=()=>{
    if($(".sidebar").is(":visible")){
        $(".sidebar").css("display","none");
        $(".matter").css("margin-left","0%");
    }else{
        $(".sidebar").css("display","block");
        $(".matter").css("margin-left","20%");
    }
}