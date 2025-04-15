# 얼굴 분할 이미지 분석기

<p align="center">
  <img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white" />
  <img src="https://img.shields.io/badge/fastapi-009688?style=for-the-badge&logo=fastapi&logoColor=white" />
  <img src="https://img.shields.io/badge/huggingface-FF9A00?style=for-the-badge&logo=huggingface&logoColor=white" />
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white" />
</p>

이미지 처리 기반 얼굴 분할 애플리케이션으로, 사용자가 업로드한 이미지를 분석하여 배경, 눈, 코, 귀, 입술 등으로 분할해주는 시스템입니다.

## 모델 정보
🤗 Hugging Face 모델: [jonathandinu/face-parsing](https://huggingface.co/jonathandinu/face-parsing)

## 주요 기능
- 이미지 업로드 및 얼굴 인식
- 얼굴 요소별 세그먼테이션(분할)
  - 배경, 눈, 코, 귀, 입술 등 파싱
- 분석 결과 시각화

## 기술 스택

| 영역       | 기술 |
|------------|------|
| 프론트엔드 | HTML, CSS, JavaScript |
| 백엔드     | FastAPI |
| AI         | Python, Hugging Face |

## 실행 방법

### 서버 실행
```bash
# 필요 패키지 설치
pip install -r requirements.txt

# 서버 실행
uvicorn main:app --reload
# 또는
python main.py
```

### 웹 인터페이스 접속
1. 브라우저에서 `http://localhost:8000` 접속하여 ai모델이 정상으로 작동하는지 확인
2. 스프링 부트에서 refresh gradle => restart 하여 `http://localhost:8080` 접속
3. 이미지 업로드 버튼을 통해 분석할 이미지 선택
4. 분석 결과 확인



## 개발 배경
이 프로젝트는 LLM 개인 프로젝트에서 핵심봇(텍스트 요약)과 같은 시기에 완성되었으며, 이미지 처리와 얼굴 인식 기술을 활용한 응용 프로그램입니다

## 개발자 정보
- [GitHub 블로그](https://ssuuoo12.github.io)
- 이메일: ssszzy333@gmail.com
