package com.thanos.api.common;


public enum PushCode {


      PUSH001("Super Like 도착!\n 지금 바로 확인해보세요.")       //Super Like 받았을 때
    , PUSH002("내가 보낸 Super Like 결과가 도착했습니다.")       //Super Like 결과 도착
    , PUSH003("좋아요 도착!\n 지금 바로 확인해보세요.")           //좋아요 받았을 때
    , PUSH004("내가 보낸 Like 결과가 도착했습니다.")             //현재 사용안하고있음
    , PUSH005("좋아요 연결 성공!\n 용기 내어 첫 인사를 건내보세요.")//'좋아요' 연결 성공됐을 때

    /* 신규심사, 수정심사 */
    , PUSH201("프로필 사진이 거절 되었습니다.\n새로운 사진을 등록해주세요.")
    , PUSH202("프로필 사진이 승인 되었습니다.")

    /* 1:1 문의 관리자 답변 */
    , PUSH301("1:1 문의 답변이 도착했습니다.\n[문의내역]에서 답변을 확인하세요.")

    /* 관리자 쪽지 */
    , PUSH401("운영자 메시지가 도착했습니다.\n[문의내역]에서 확인하세요.")

    /* 신고처리 ( 신고당한 회원 ) */
    , PUSH501("내 계정이 신고처리 되었습니다.")

    ;
    private String pushMsg;

    PushCode(String pushMsg) {
        this.pushMsg = pushMsg;
    }

    public String getPushMsg() {
        return pushMsg;
    }
}
