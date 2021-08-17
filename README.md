# OIDC_Social_Service (소셜 서비스)
심박수 기반 영화 순위 제공서비스 'Movie by Heart'의 소셜 서비스를 구성하는 레포지토리

## Controller
  
- 댓글 등록(POST) **/comments/cid**
  - parameter : cid ( required False ), CommentDto
  
  <br>

- 댓글 삭제(GET)  **/comments/delete/cid**
  - parameter : cid
  
  <br>
  
- 댓글 리스트 반환(GET) **/comments/title**
  - parameter : title, CommentDto
  
  <br>
  
- 심박수 데이터 전송(POST)  **/bpmsend**
  - parameter : BpmDto
  
  <br>

## Interface
- getUid() : 사용자 고유 ID를 가져오는 기능

- getMid() : 영화 고유 ID를 가져오는 기능

- getTid() : 측정 데이터 고유 ID를 가져오는 기능

- insertTitle() : 영화 정보가 없을 때, DB에 Insert 하기 위한 기능

- insertComment() : 댓글(리뷰)를 Insert 하기 위한 기능

- selectCommentDetail() : 댓글 정보를 가져오기 위한 기능

- updateComment() : 댓글 업데이트 (추가 및 수정)

- deleteComment() : 댓글 삭제

- selectCommentList() : 해당 영화의 댓글 모두 가져오기

- insertBpmTest() : 측정 고유 정보 Insert 하기 위한 기능

- insertBpmData() : 측정한 심박수를 Insert 하기 위한 기능

<br>
