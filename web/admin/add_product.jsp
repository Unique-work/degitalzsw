<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
<title>商品添加</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../ckfinder/ckfinder.js"></script>
<link type="text/css" rel="stylesheet" href="../style/main.css" />
<script type="text/javascript">
function BrowseServer( inputId )
{
var finder = new CKFinder() ;
finder.BasePath = '../ckfinder/' ;
finder.selectActionFunction  = SetFileField ;
finder.selectActionData  = inputId ;
finder.popup() ;
}
function SetFileField( fileUrl, data )
{
document.getElementById( data["selectActionData"] ).value = fileUrl ;
}
</script>
</head>

<body>
	<form id="add_news" name="add_news" method="post" action="../ProductServlet">
		<input type="hidden" name="flag" value="add" >
		<div id="regist">
		<table border="0" bordercolor="#4f6b72">
      	<tr>
      	  <td class="row" colspan="6" align="center"><h1>商品信息添加</h1></td>
      	</tr>
        <tr>
          <td class="row">商品名称:</td>
          <td><input type="text" name="name" ><font color="red">*</font></td>
          <td class="row">商品编码:</td>
          <td><input type="text" name="code" ><font color="red">*</font></td>
          <td class="row">商品品牌:</td>
          <td><input type="text" name="brand" ><font color="red">*</font></td>
        </tr>
        <tr>
          <td class="row">商品价格:</td>
          <td><input type="text" name="price"><font color="red">*</font></td>
          <td class="row">促销价格:</td>
          <td><input type="text" name="sale"><font color="red">*</font></td>
           <td class="row">商品类别:</td>
          <td>
          <select name="type" style="font: 黑体;width: 155">
          <option value="">请选择商品种类</option>
          <option value="电脑">电脑</option>
          <option value="手机">手机</option>
          <option value="相机">相机</option>
          <option value="其他">其他</option>
          </select><font color="red">*</font>
          </td>
         
        </tr>
       
        <tr>
          <td class="row">商品图片:</td>
          <td><input type="text" name="pic" id="pic" onclick="BrowseServer('pic');" ><font color="red">*</font>
          </td>
          <td class="row">商品数量:</td>
          <td><input type="text" name="num" ><font color="red">*</font></td>
          <td class="row"><input type="submit" value="保存"/></td>
          <td class="row"><input type="reset" value="重置"/></td>
        </tr> 
      </table>
			<textarea id="intro" name="intro" class="ckeditor" rows="10" cols="80">&nbsp;</textarea>
		</div>
		
	</form>
</body>

</html>
