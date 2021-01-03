<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manageExam.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/superTables.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jFixed.min.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
		<!--
		body,div,p,ul,li,font,span,td,th{
		font-size:10pt;
		line-height:155%;
		
		}
		
		table{
		border-top-width: 1px;
		border-right-width: 1px;
		border-bottom-width: 0px;
		border-left-width: 1px;
		border-top-style: solid;
		border-right-style: solid;
		border-bottom-style: none;
		border-left-style: solid;
		border-top-color: #CCCCCC;
		border-right-color: #CCCCCC;
		border-bottom-color: #CCCCCC;
		border-left-color: #CCCCCC;
		border:1px solid #CCCCCC;
		}
		td{
		border-bottom-width: 1px;
		border-bottom-style: solid;
		border-bottom-color: #CCCCCC;
		border:1px solid #CCCCCC;
		}
		
		.EditCell_TextBox {
		width: 90%;
		border:1px solid #0099CC;
		}
		.EditCell_DropDownList {
		width: 90%;
		}
		-->
		</style>
		<script language="javascript">
//var tabProduct = document.getElementById("tabProduct");
//  
// 设置表格可编辑
// 可一次设置多个，例如：EditTables(tb1,tb2,tb2,......)
//EditTables(tabProduct);
    $(function() {
       
        var i = 1;
        var da = { pkey: [{ key: "num", value: i}], value: [[{ key: 1, value: '' }, { key: 2, value: i }, { key: 1, value: 'A' }, { key: 1, value: '3' }, { key: 1, value: '4' }, { key: 1, value: '5'}]] }
;
        var op = { data: da, headerRows: 2 };
        $.jtool.loaddata("tabProduct", op);
        //$("#tabProduct").toSuperTable({ fixedCols:1,width: "500px",height: "200px", headerRows: 2});
        $("#tabProduct").jFixedtable({ colums: [{ name: "num"}], fixedCols: 2, width: "550", height: "300", headerRows: 2, pkey: ["num"], edit: true });
        //$("#tabProduct").jGrid({ ftb: { headerRows: 3,  width: "500"} });
        //$("#tabProduct").jGrid();
        //$("#tabProduct").TableLock({lockRow:2,lockColumn:2,width:600,height:250});
        //$.jtool.addRow('tabProduct', op);
        i += 1
        $("#add").click(function() {
            var da = { pkey: [{ key: "num", value: i}], value: [[{ key: 1, value: '' }, { key: 2, value: i }, { key: 1, value: 'A' }, { key: 1, value: '3' }, { key: 1, value: '4' }, { key: 1, value: '5'}]] }
;
            var op = { data: da };
            i++;
            $.jtool.addRow('tabProduct', op);
        });
    });

    function gettr() {
        var trs = $.jtool.getchangetr();
        for (var i = 0; i < trs.length; i++) {
            var tr = trs[i]; 
            var pk = eval(tr.pkey);
            for (var j = 0; j < pk.length; j++) {
                alert("修改行主键："+pk[j].key+"="+pk[j].value);
            }
            var values = tr.values;
        }
    }

    function del(key) {
        //alert(key.length);
        for (var i = 0; i < key.length; i++) {
            var pkey = key[i];
            for (var j = 0; j < pkey.length; j++) {
                alert(pkey[j].key + ":" + pkey[j].value);
            }
        }
        return true;       
    }
</script>
  	</head>
  
  <body>
    <form id="form1" name="form1" method="post" action="">
		<h3>固定行列可编辑的表格</h3>
		<div>
		<h3>功能：</h3>
		<ul>
		<li>固定行列</li>
		<li>可以在表格直接编辑</li>
		<li>使用ajax对数据操作</li>
		<li>使用tab键在可编辑列切换</li>
		</ul>
		</div>
		例：
		<table  width="608"  id="tabProduct">
		    <tr>
		      <td width="20" style="text-align:center;"  align="center"  rowspan="2" bgcolor="#EFEFEF" Name="Num"><input type="checkbox" name="checkbox" value="checkbox" /></td>
		      <td width="60" style="text-align:center;"  bgcolor="#EFEFEF" Name="Num" rowspan="2"  style=" text-align:center">序号</td>
		      <td width="478" style="text-align:center;"  bgcolor="#EFEFEF" colspan="4" >合计</td>   
		    </tr>
		    <tr>
		      <td width="152" bgcolor="#EFEFEF" style="text-align:center;"  Name="ProductName" EditType="DropDownList" DataItems="{text:'A',value:'a'},{text:'B',value:'b'},{text:'C',value:'c'},{text:'D',value:'d'}">商品名称</td>
		      <td width="103" bgcolor="#EFEFEF" style="text-align:center;" Name="Amount" EditType="TextBox">数量</td>
		      <td width="103" bgcolor="#EFEFEF" style="text-align:center;"  Name="Price" EditType="TextBox">单价</td>
		      <td width="120" bgcolor="#EFEFEF" style="text-align:center;"  Name="SumMoney" Expression="Amount*Price" Format="#,###.00">合计</td>
		    </tr>
		    
		     
		</table>
		
		<p><br />
		    <input id="add" type="button" name="add" value="新增"/>
		    <input type="button" name="Submit2" value="删除" onclick="$.jtool.deleteRow('tabProduct',del)" />
		    <input type="button" name="Submit2" value="修改行信息" onclick="gettr();" />
		    <input type="button" name="Submit22" value="重置" onclick="window.location.reload()" />
		    <input type="submit" name="Submit3" value="提交" onclick="return false;" />
		</p>

	</form>
  </body>
</html>
