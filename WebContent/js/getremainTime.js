$(document).ready(function(){  
 window.onload = function(){  
     var totleSecond = initTimer();  
     startTime(totleSecond);   //开始倒计时  
 }  
   
 function initTimer(){  
     var totleSecond = $("#remainingTime").val(); //获取上图的input的剩余时间  
     alert(totleSecond);
     return totleSecond;  
 }  
 function AutoSubmit(){
	 $('#form1').submit();
 }
 function startTime(totleSecond){  
     $("#time").text(formatTime(totleSecond));  
     var timer = setInterval(function(){  
         totleSecond -= 1 ;  
         $("#remainingTime").val(totleSecond);   //给上图的input更新剩余时间  
         if(totleSecond >=0 ){  
             $("#time").text(formatTime(totleSecond));  
         }else{  
             AutoSubmit();  
             alert("考试结束！")  
             clearInterval(timer);  
             $("#remainingTime").val("");    
         }  
     },1000)  //setinterval隔一秒更新一次时间
 }  
 function formatTime(totleSecond){  //格式化时间
     var hour = Math.floor(totleSecond/3600);  
     var minute = Math.floor((totleSecond%3600)/60);  
     var second = Math.floor(totleSecond%60);  
   
     hour = formatTimeNumber(hour);  
     minute  = formatTimeNumber(minute)  
     second  = formatTimeNumber(second);  
     return (hour +":"+minute+":"+second)  
 }  
 function formatTimeNumber(number){  
     if(number<10){  
         return "0"+number;  
     }else{  
         return number;  
     }  
 } })