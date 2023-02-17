package com.gaemanda.gaemanda.Domain;

import lombok.Getter;

public enum DogMbtiType {
    CTEA("쾌할한 만능엔터테이너형", "만능 엔터테이너에요. " +
            "텐션에 맞춰서 놀 친구를 좋아합니다."),
    CTEL("신이 내린 반려특화형", "강아지 계의 유재석입니다. " +
            "같이 놀 침착한 성격의 친구를 좋아합니다."),
    CTIA("놀 줄 아는 모범생형", "보호자와 놀이하고 싶어합니다. " +
            "힐 트레이닝을 통해 같이 성장할 친구를 선호해요."),
    CTIL("모범견계의 엄친아형", "엄마들이 좋아하는 엄친아네요. " +
            "공격적인 아이들보다 순한 아이들을 선호하비다."),
    CNEA("똥꼬발랄 핵인싸형", "핵인싸입니다. " +
            "어떤 친구도 좋아하지만 상처주지 않을 친구를 찾아요."),
    CNEL("곱게 자란 막내둥이형", "우리집 막둥이네요. " +
            "단호하기보다 소프트한 성격의 친구를 찾아요."),
    CNIA("주위에 관심없는 나 혼자 산다형", "새로운 환경에서 혼자 노는걸 좋아해요. " +
            "같이 플레이 트레이닝할 친구를 찾아요."),
    CNIL("치고 빠지는 밀당천재형", "고양이처럼 밀당을 잘하고 혼자서도 잘 지내요. " +
            "같이 플레이 트레이닝을 할 친구를 찾아요"),
    WTEA("허세부리는 호기심쟁이", "호기심 많은 탐험가 스타일의 아이입니다. " +
            "포인트 훈련을 통해 같이 성장할 친구를 찾아요."),
    WTEL("초면엔 신중, 구면엔 친구", "좋아하는 사람, 친구에게만 개구쟁이에요. " +
            "노즈워크를 통해 같이 성장할 친구를 찾아요."),
    WTIA("조심스러운 관찰자형", "돌다리도 두덜겨보고 건너는 신중한 아이입니다. 해치치만 않으면 어떤 친구도 좋아하는 아이입니다."),
    WTIL("엄마 껌딱지 겁쟁이형", "자신을 지키기 위해 매우 방어적인 아이입니다. 1일 1야외산책을 같이할 친구를 찾아요."),
    WNEA("동네 대장 일진형", "동네 대장 스타일이에요. " +
            "주도권 훈련(오비디언스)을 통해 같이 성장할 친구를 찾아요."),
    WNEL("까질한 지킬 앤 하이드형", "까질한 예민보스, 방구석제왕 입니다. " +
            "엎드려 훈련을 통해 같이 성장할 친구를 찾아요."),
    WNIA("선긋는 외톨이형", "보호자를 비즈니스 관계로 대하는 아이입니다. " +
            "실내산책을 통해 같이 성장할 친구를 찾아요."),
    WNIL("패닉에 빠진 극소심형", "금방이라도 깨질 것만 같은 유리멘탈을 가진 아이입니다. 아직 보호자와 같이 지낼 성격입니다. 순한 친구를 찾아요."),

    ;


    private final String title;
    private final String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    DogMbtiType(String title, String description){
        this.title = title;
        this.description = description;
    }

    public static void main(String[] args) {
        System.out.println(DogMbtiType.valueOf("CTEA").getTitle());
    }
}
