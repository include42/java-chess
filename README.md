# 체스 1단계 - 체스판 초기화

## **기능 요구사항**

- 콘솔 UI에서 체스 게임을 할 수 있는 기능을 구현한다.
- 1단계는 체스 게임을 할 수 있는 체스판을 초기화한다.
- 체스판에서 말의 위치 값은 가로 위치는 왼쪽부터 a ~ h이고, 세로는 아래부터 위로 1 ~ 8로 구현한다.
- 체스판에서 각 진영은 검은색(대문자)과 흰색(소문자) 편으로 구분한다.

### **프로그램 실행 결과**

    체스 게임을 시작합니다.
    게임 시작은 start, 종료는 end 명령을 입력하세요.
    start
    RNBQKBNR
    PPPPPPPP
    ........
    ........
    ........
    ........
    pppppppp
    rnbqkbnr
    
    end

기능 구현

- [x]  Position 구현.
- [x]  Board 구현.
- [x]  추상 클래스 Piece 구현.
- [x]  Direction Enum 구현.
- [x]  Movable interface 구현.(결과로 이동 가능한 position들 반환)
- [x]  Color Enum 구현.
- [x]  세부 유닛들 상속하여 구현.
- [x]  List<Piece>의 Player 일급 컬렉션
- [x]  List<Piece> Factory 구현.
- [x]  ChessGame 구현.
- [x]  OperationType 구현.
- [x]  컨트롤러.
- [x]  뷰.
- [x]  특수 이동 룰.
- [x]  King이 잡힐 시 게임 종료.

