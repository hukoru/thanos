package com.thanos.api.common.constant;

import com.thanos.api.result.ErrorInfo;


public enum ErrorInfoEnum implements ErrorInfo {

      ERR0001("ERR0001","등록된 회원정보가 없습니다.")
    , ERR0002("ERR0002","오류가 발생하였습니다. 관리자에게 문의하여 주십시오.")
    , ERR0003("ERR0003","로그아웃 상태입니다.")
    , ERR0004("ERR0004","비밀번호가 올바르지 않습니다.")


    , ERR0007("ERR0007","이성이 없습니다.")


    , ERR0012("ERR0012","보유한 파이어가 부족합니다.")
    , ERR0013("ERR0013","닉네임이 중복됩니다.")
    , ERR0014("ERR0014","올바른 확장자가 아닙니다.")


    , ERR0017("ERR0017","오늘의 매칭이 끝났습니다.")
    , ERR0018("ERR0018","오늘의 매칭할 이성이 없습니다")

    , ERR0025("ERR0025","블랙리스트 회원입니다.")
    , ERR0027("ERR0027","비밀번호가 빈값입니다.")
    , ERR0028("ERR0028","성별이 빈값입니다.")
    , ERR0029("ERR0029","나이가 빈값입니다.")
    , ERR0032("ERR0032","종교가 빈값입니다.")
    , ERR0033("ERR0033","직업이 빈값입니다.")
    , ERR0035("ERR0035","닉네임이 빈값입니다.")
    , ERR0036("ERR0036","키가 빈값입니다.")
    , ERR0037("ERR0037","다른기기에서 로그인 되어 로그아웃 됩니다.")
    , ERR0038("ERR0038","유효하지 않은 영수증입니다.")
    , ERR0039("ERR0039","구매 서버를 현재 사용할 수 없습니다.")
    , ERR0040("ERR0040","로그인 시간이 만료되어 재로그인이 필요합니다.")
    , ERR0041("ERR0041","영문, 숫자, 특수문자만 입력 가능합니다.")
    , ERR0042("ERR0042","이미 회원가입된 기기입니다. 회원탈퇴 후 재가입 해주십시오.")
    , ERR0043("ERR0043","사진 업로드시 오류가 발생하였습니다.")
    , ERR0044("ERR0044","서버 점검중입니다. 불편을 끼쳐드려 대단히 죄송합니다.")
    , ERR0045("ERR0045","기존 매력평가를 한 이력이 존재합니다.")

    , ERR0048("ERR0048","정기권 기간이 만료되었습니다.")
    , ERR0049("ERR0049","정기권 정보를 갱신하는데 실패하였습니다.\n잠시 후 다시 시도해주세요.")
    , ERR0051("ERR0051","등록된 회원정보가 없습니다")
    , ERR0052("ERR0052","정보가 반영되지 않았습니다. \n 잠시 후 다시 시도해주세요.")
    , ERR0053("ERR0053","등록된 회원정보가 있습니다")
    , ERR0054("ERR0054","등록된 알람설정이 존재하지 않습니다.")
    , ERR0055("ERR0055","이미 가입된 기기입니다. 이 기기에서 가입한 계정을 탈퇴하신 후 재가입 해주십시오.")
    // , ERR0056("ERR0056","해당 조건의 이성들이 없습니다., 이상형 필터 조건을 다시 설정하시면\n 더 많은 이성들을 만나실 수 있어요.")
    , ERR0056("ERR0056","현재 해당 조건의 상대를 찾지 못했습니다., 하지만 매일 수많은 이성들이 가입중이니\n다음에 다시 확인해주세요.")

    , ERR0060("ERR0060","뱅 보내는 중 오류가 발생하였습니다.\n잠시 후 다시 시도해주세요. ")
    , ERR0061("ERR0061","잘못된 접근입니다 다시 시도해주십시오 ")

    , ERR0062("ERR0062","현재 비밀번호를 확인하십시오")
    , ERR0063("ERR0063","비밀번호에는 공백이 들어갈 수 없습니다.")
    , ERR0064("ERR0064","비밀번호의 길이는 최소 4자입니다.")
    , ERR0065("ERR0065","비밀번호는 12자를 넘을 수 없습니다.")
    , ERR0066("ERR0066","비밀번호는 한글이 포함될 수 없습니다.")

    , ERR0067("ERR0067","검색결과가 없습니다.")
    , ERR0068("ERR0068","기존 뱅한 이력이 존재합니다.")
    , ERR0070("ERR0070","삭제할 해당 이미지가 존재하지 않습니다.")
    , ERR0071("ERR0071","메인 이미지는 삭제하실 수 없습니다.")
    , ERR0072("ERR0072","메인이미지로 변경하실 수 없습니다.")
    , ERR0073("ERR0073","등록된 SUB 이미지가 존재하지 않습니다.")
    , ERR0074("ERR0074","등록된 관심사가 있습니다.")
    , ERR0075("ERR0075","채팅 채널을 찾을수 없습니다.")
    , ERR0076("ERR0076","이미 등록된 연결성공 데이터가 있습니다.")
    , ERR0077("ERR0077","등록된 MAIN 이미지가 존재하지 않습니다.")
    , ERR0078("ERR0078","이미 나간 채팅방입니다.")
    , ERR0079("ERR0079","정책위반으로 인해 계정이 정지되어 서비스를 이용할 수 없습니다. 문의사항은 support@bangbangmatch.com으로 보내주시기 바랍니다.")
    , ERR0080("ERR0080","로그인할 수 없는 계정입니다.")
    , ERR0081("ERR0081","기존 등록된 채팅 채널이 존재합니다.")
    , ERR0082("ERR0082","회원 정보를 조회하는데 실패하였습니다. 관리자에게 문의하여 주십시오.")

    , ERR0084("ERR0084","닉네임에는 공백을 입력하실 수 없습니다.")
    , ERR0087("ERR0087","정책위반으로 인해 정지된 계정입니다.")

    , ERR0601("ERR0601","위치정보를 허용해야, 이성을 소개받을 수 있습니다. 허용하시겠습니까?")

    , ERR0701("ERR0701","앱 스토어가 제공 한 JSON 객체를 읽을 수 없습니다.")
    , ERR0702("ERR0702","수신 데이터 속성의 데이터 형식이 잘못되었습니다.")
    , ERR0703("ERR0703","영수증 인증을 할 수 없습니다.")
    , ERR0704("ERR0704","공유 비밀번호가 일치하지 않습니다.")
    , ERR0705("ERR0705","수신서버는 현재 사용할 수 없습니다.")
    , ERR0706("ERR0706","이 영수증은 유효하지만 구독이 만료되었습니다.")
    , ERR0707("ERR0707","이 영수증은 제품 수령이지만 확인을 위해 샌드 박스 서비스로 전송되었습니다.")
    , ERR0708("ERR0708","inApp결제 결과 데이터가 빈값입니다. (앱스토어에서 결제 처리가 완료되지 않은 상태)")

    , ERR0901("ERR0901","결제 승인 중 오류가 발생하였습니다.[취소된 결제건]")
    , ERR0902("ERR0902","결제 승인 중 오류가 발생하였습니다.[유효하지 않은 결제]")
    , ERR0903("ERR0903","결제 승인 중 오류가 발생하였습니다.[결제검증 오류]")
    , ERR0904("ERR0904","결제 승인 중 오류가 발생하였습니다.[결제검증 권한 오류]")
    , ERR0905("ERR0905","결제 승인 중 오류가 발생하였습니다.[이미 처리된 결제건]")
    , ERR0912("ERR0912","정기권 결제 승인 중 오류가 발생하였습니다.[취소된 결제건]")
    , ERR0913("ERR0913","정기권 결제 승인 중 오류가 발생하였습니다.[만료된 정기권]")
    , ERR0914("ERR0914","정기권 결제 승인 중 오류가 발생하였습니다.[관리자에 의해 중지된 정기권]")
    , ERR0915("ERR0915","정기권 승인 중 오류가 발생하였습니다.[이미 처리된 결제건]")
    , ERR0916("ERR0916","{\"msg\":\"등록하신 사진은 얼굴이 인식되지 않거나 선명하지 않아 확인이 어렵습니다.\\n얼굴이 선명하게 보이는 사진을 새로 등록한 후 다시 시도해주세요.\", \"imageWidth\": 1242, \"imageHeight\": 1620, \"imageUrl\": \"https://s3.ap-northeast-2.amazonaws.com/colondee-hobby/error/signin_message.png\"}")
    , ERR0917("ERR0917","정기권 확인이 잠시 지연되고 있습니다. 잠시후 다시 시도해 주세요.")

    , ERR0918("ERR0918","채팅방 열기중에 오류가 발생하였습니다. [정기권 회원]")
    , ERR0919("ERR0919","채팅방 열기중에 오류가 발생하였습니다. [채팅 URL오류]");

    private String code;

    private String message;

    ErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
