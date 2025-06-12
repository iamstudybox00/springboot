function formValidate(frm){
    /*
    <form>에서 this를 통해 전달한 인수는 다음과 같다. 
    1. document.forms[0];
    2. document.myform;
    즉 <form> 태그의 DOM 객체이다. 
    */
    
    //아이디에 입력한 값이 있는지 확인한다. 
    if(frm.id.value==''){
        alert("아이디를 입력해주세요.");
        frm.id.focus();
        return false;
    }

    //아이디는 8~12자로 입력되었는지 검증
    if(!(frm.id.value.length>=8 && frm.id.value.length<=12)){
        //8~12자 사이가 아니라면..
        alert("아이디는 8~12자 사이만 가능합니다.");
        //입력된 값을 지우고 포커스를 이동한다. 
        frm.id.value = '';
        frm.id.focus();
        return false;
    }

    //아이디는 숫자로 시작할 수 없음
    /* 0과 9의 아스키코드값은 각각 48, 57이므로 아이디의 첫글자가
    만약 이 사이에 존재한다면 사용할 수 없는 아이디로 판단할 수 있다. */
    //입력한 아이디와 첫번째 문자, 아스키코드를 콘솔에서 확인한다. 
    console.log(frm.id.value, frm.id.value[0], 
        frm.id.value.charCodeAt(0));
    if(frm.id.value[0].charCodeAt(0)>=48 &&
            frm.id.value.charCodeAt(0)<=57){
        alert('아이디는 숫자로 시작할 수 없습니다.');
        frm.id.value = '';
        frm.id.focus();
        return false;
    }

    //아이디는 영문+숫자의 조합으로만 사용할 수 있다. 
    /* 아이디를 구성하는 각 문자가 소문자 a~z, 대문자 A~Z, 숫자 0~9
    사이가 아니라면 잘못된 문자가 포함된 경우이므로 전송을 중단한다.*/

    //아이디의 길이만큼 반복한다. 
    for(var i=0 ; i<frm.id.value.length ; i++){
        if(!((frm.id.value[i]>='a' && frm.id.value[i]<='z') ||
            (frm.id.value[i]>='A' && frm.id.value[i]<='Z') ||
            (frm.id.value[i]>='0' && frm.id.value[i]<='9'))){
            alert("아이디는 영문 및 숫자의 조합만 가능합니다.");
            frm.id.value='';
            frm.id.focus();
            return false; 
        }
    }


    //패스워드 입력 확인
    if(frm.pass1.value==''){
        alert("패스워드를 입력해주세요.");frm.pass1.focus();return false;
    }
    if(frm.pass2.value==''){
        alert("패스워드 확인을 입력해주세요.");frm.pass2.focus();return false;
    }
    //만약 입력한 패스워드가 일치하지 않는다면..
    if(frm.pass1.value!=frm.pass2.value){
        alert('패스워드가 일치하지 않습니다. 다시 입력해주세요.');
        //사용자가 입력한 패스워드를 지운다. 
        frm.pass1.value = '';
        frm.pass2.value = '';
        //입력상자로 포커싱 한다. 
        frm.pass1.focus();
        return false;
    }

    //생년월일의 성별은 라디오 이므로 선택여부를 통해 검증한다. 
    var isSex = false;
    for(var i=0 ; i<frm.sex.length ; i++){
        //남자/여자 중 선택한 항목이 있는지 확인한다. 
        if(frm.sex[i].checked==true){
            //라디오는 항목중 하나만 선택할 수 있으므로 boolean타입의
            //변수를 통해 확인하면 된다. 
            isSex = true;
            //체크된 항목이 있으면 즉시 반복문을 탈출한다. 
            break;
        }
    }
    //선택한 항목이 없다면 경고창을 띄운다. 
    if(isSex==false){
        alert('성별을 선택해 주세요.');
        frm.sex[0].focus();
        return false;
    }
 
    
    //폼 검증이 끝난후 서버로 전송 직후 로딩 이미지를 띄워준다. 
    document.getElementById("id_loading").style.display = 'block';
	return true;
}