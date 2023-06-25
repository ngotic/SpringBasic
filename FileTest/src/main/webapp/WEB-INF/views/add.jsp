<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	#attach-zone {
		border:1px solid var(--border-color);
		background-color: var(--back-color);
		width: 300px;
		height: 150px;
		overflow: auto;
	}
	
	#attach-zone .item {
		display: flex;
		justify-content : space-between;
		font-size : 14px;
		margin : 5px 10px;
	}
	
</style>
</head>
<body>
	<!--  add.jsp -->
	<h1>파일 업로드</h1>
	
	<form method="POST" action="/file/addok.do" enctype="multipart/form-data" id="form1">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="attach"></td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>	
	</form>
	
	
	
	<h1>다중 파일 업로드(multiple)</h1>
	
	<form method="POST" action="/file/multiaddok.do" enctype="multipart/form-data" id="form2">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="attach" multiple></td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>	
	</form>
	
	
	<h1>다중 파일 업로드(File Drop)</h1>
	
	<form method="POST" action="/file/multiaddok.do" enctype="multipart/form-data" id="form3">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
				<td>
					<!-- 여기에다가 드래그엔 드롭한다. -->
					<div id="attach-zone"></div>
					<input type="file" name="attach" id="attach3" style="display:none;">
				</td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>	
	</form>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	function checkFile(filename, filesize){
	
		const maxsize = 10485760;
		const regex = /(.*?)\.(exe|sh|zip|jpg)$/gi;
		// 실행파일 업로드 못하게 정규식을 붙이자.
		
		if(filesize >= maxsize){
			alert("단일 파일의 크기가 10MB 이하만 가능합니다.");
			return false;
		}
		
		if(regex.test(filename)){
			alert('해당 파일은 업로드할 수 없습니다.');
			return false;
		}
			
	}
		
		
		//전송되기 바로 직전에 발생하는 이벤트
		$('#form1').submit(function(){
			alert(111);
			let filename = $('input[name=attach]')[0].files[0].name;
			alert(filename);
			
			let filesize = $('input[name=attach]')[0].files[0].size;
			alert(filesize);
			
			
			
			if(!checkFile(filename, filesize)){
				
				// 전송금지!
				event.preventDefault();
				return false;
			}
		});
		
		
		//전송되기 바로 직전에 발생하는 이벤트
		$('#form2').submit(function(){
			
			//let filename = $('input[name=attach]')[0].files[0].name;
			//let filesize = $('input[name=attach]')[0].files[0].size;
			let totalsize = 0;
			// ★ 만약에 파일의 총크기가 크면 에러나게한다. 
			// 아래것을 선택 
			Array.from($('input[name=attach]')[1].files).forEach(file => {
				
				if(!checkFile(file.name, file.size)){
					// 전송금지!
					event.preventDefault();
					return false;
				}	
				totalsize += file.size();
			});
			if(totalsize >= 52428800){
				alert('총 파일 크기의 합이 50MB 이하만 가능합니다.');
				event.preventDefault(); // 전송을 막고 
				return false; // 막는다.
			}
		});
	
		
		$('#attach-zone')
		
			.on('dragenter', function(e){
				e.preventDefault();
				e.stopPropagation();
			})
			.on('dragover', function(e){
				e.preventDefault();
				e.stopPropagation();
				$(this).css('background-color','gold');
			})
			.on('dragleave', function(e){
				e.preventDefault();
				e.stopPropatation();
				$(this).css('background-color','var(--back-color)');
			})
			.on('drop', function(e){
				
				$(this).empty();
				
				e.preventDefault();
				
				const files = e.originalEvent.dataTransfer.files;
				
				if ( files != null && files != undefined){
					
					let temp = '';
					
					for(let i=0; i<files.length; i++){
						// console.log(files[i].name);
						let f = files[i];
						let filename = f.name;
						let filesize = f.size / 1024/ 1024; // MB 변환
						
						filesize = filesize < 1 ? filesize.toFixed(2) : filesize.toFixed(1);
						
						 temp += `
							 <div class="item">
							 	<span>\${filename}</span>
							 	<span>\${filesize}MB</span>
							 </div>
						 `;
					}//for
					
					$(this).append(temp);
				}// if 
				
				$(this).css('background-color','var(--back-color)');
				
				$('#attach').prop('files', )
			});
		
</script>
</body>
</html>






