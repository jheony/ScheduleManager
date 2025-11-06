# 일정 관리 API
--- 
- Spring Boot와 JPA를 사용하여 일정 및 댓글 관리가 가능한 REST API를 구현한 프로젝트입니다. 

## 목차
1. [프로젝트 개요](#프로젝트-개요)
 - 주요 기능
 - 주요 기술 스택

2. [산출물](#산출물)
 - 기능 명세서
 - API
 - ERD

3. [결과물](#프로젝트-결과물)


# 프로젝트 개요

---

## 프로젝트 진행 기간

---

- 2025.11.03(월) - 2025.11.06(목)
- 내일배움캠프 Spring 9기 개인 프로젝트


## 주요 기능

---
### 1. 필수 기능 (Lv.1 ~ Lv.4)
* **일정 생성:**
    * 제목, 내용, 작성자, 비밀번호를 입력받아 일정을 생성합니다.
* **일정 조회:**
    * **전체 조회:** 모든 일정을 수정일 기준 내림차순으로 정렬하며, 작성자명으로 필터링 할 수 있습니다.
    * **선택 조회:** 선택한 일정 ID로 해당 일정을 조회합니다.
* **일정 수정:**
    * 비밀번호 검증 성공 시, 일정제목과 작성자명을 수정할 수 있습니다.
* **일정 삭제:**
    * 비밀번호 검증 성공 시, 일정과 해당 일정에 등록된 댓글을 삭제합니다.

### 2. 도전 기능 (Lv.5 ~ Lv.7)
* **댓글 생성:**
    * 특정 일정에 내용, 작성자를 포함한 댓글을 10개까지 등록할 수 있습니다.
* **일정 조회 업그레이드:**
    * 일정 단건 조회 시, 해당 일정에 등록된 댓글 목록을 함께 조회합니다.
* **유효성 검사:**
    * `@Valid`를 사용하여 모든 주요 입력값(제목, 내용, 작성자명 등)에 대해 공백 및 길이 제한 검증을 수행합니다.
* **전역 예외 처리:**
    * `@RestControllerAdvice`를 사용하여 유효성 검사 실패, 비밀번호 불일치(`CustomException`) 등 발생하는 예외를 일괄 처리하고, 명확한 오류 메시지를 반환합니다.

---



## 기술 스택

---
- Java: open-JDK 17
- Spring-boot: 3.5.7
- MySQL: 8.4
- IntelliJ version: 25.2.2
- API Test: Postman


# 산출물

---

## 프로젝트 산출물

---

### API 명세서
  - [Postman API](https://documenter.getpostman.com/view/49692886/2sB3WpRgVH)
    <p align-"center"><img width="2234" height="1401" alt="image" src="https://github.com/user-attachments/assets/595582ce-b967-4d39-83c6-01c243048981" /></p>
    <p align-"center"><img width="2222" height="1385" alt="image" src="https://github.com/user-attachments/assets/deb50ff3-d60d-4bfe-a19f-600000dabbdc" /></p>
    <p align-"center"><img width="2215" height="855" alt="image" src="https://github.com/user-attachments/assets/d06a675c-68e6-4865-aa9c-552164f6bbca" /></p>
### ERD

<p align="center"><img width="827" height="285" alt="스크린샷 2025-11-04 143505" src="https://github.com/user-attachments/assets/7a84e26e-a99d-490e-b3c1-84c55a7c2426" /></p>


## 프로젝트 결과물

---
- 일정 생성
  <p align-"center"><img width="1299" height="755" alt="image" src="https://github.com/user-attachments/assets/538496c8-16e0-4265-adee-abcd50c8d17f" /></p>
- 일정 조회
  - 전체 조회 
    <p align-"center"><img width="1293" height="1160" alt="image" src="https://github.com/user-attachments/assets/4d704c04-1d50-40d7-87a1-3e4806e20b0b" /></p>
  - 작성자명 필터링 조회
    <p align-"center"><img width="1294" height="771" alt="image" src="https://github.com/user-attachments/assets/bb2d6443-70d2-4e25-9947-eae468298952" /></p>
  - 선택 일정 조회
    <p align-"center"><img width="1287" height="922" alt="image" src="https://github.com/user-attachments/assets/7dc05854-faa8-4da5-82af-e60a3d28f4e2" /></p>
- 일정 수정
  <p align-"center"><img width="1287" height="714" alt="image" src="https://github.com/user-attachments/assets/aacfe0e5-8f79-44e1-a0d6-aa20591a3525" /></p>
- 일정 삭제
  <p align-"center"><img width="1307" height="662" alt="image" src="https://github.com/user-attachments/assets/a8141573-49e5-4c95-a1f2-d9d99af19119" /></p>
- 댓글 생성
  <p align-"center"><img width="1286" height="711" alt="image" src="https://github.com/user-attachments/assets/ea001454-bd2c-46ef-8c76-50fdbc420120" /></p>

- 예외
  - 존재하지 않는 일정
     <p align-"center"><img width="1286" height="587" alt="image" src="https://github.com/user-attachments/assets/9886e565-4643-4a62-8a9b-e297d7df0d95" /></p>
  - 비밀번호 불일치
     <p align-"center"><img width="1278" height="574" alt="image" src="https://github.com/user-attachments/assets/32d33050-2c67-4ca0-ab54-3458db6deeef" /></p>
  - 댓글 제한 초과
    <p align-"center"><img width="1283" height="631" alt="image" src="https://github.com/user-attachments/assets/c3ec9c15-99f1-4237-af6f-6fdf4a8f9b12" /></p>

