# 문자열

> 기본적인 개념보다는, 잘 모르는 method 위주로 정리하였습니다.

## `getBytes()`

- 문자열을 바이트 배열로 변환
- 시스템의 기본 문자셋으로 인코딩된 바이트 배열 return

```java
byte[] bytes = "String".getBytes();
byte[] bytes = "String".getBytes(Charset charset);
```

- `getBytes(Charset charset)` method는 잘못된 문자셋을 매개값으로 줄 경우, `java.io.UnsupportedEncodingException`이 발생하기 때문에, 예외 처리가 필요하다.

```java
try {
    byte[] bytes1 = "문자열".getBytes("EUC-KR");
    byte[] bytes2 = "문자열".getBytes("UTF-8");
} catch (UnsupportedEncodingException e) {
}
```

- 바이트 배열을 다시 문자열로 변환(디코딩) 할 때는 어떤 문자셋으로 인코딩된 바이트 배열이냐에 따라서 디코디 방법이 다르다.
- `String(byte[] bytes)` 생성자를 이용하여 디코딩 할 경우, 시스템의 기본 문자셋을 이용한다.
- 기본 문자셋과 다른 문자셋으로 인코딩된 바이트 배열일 경우에는, `String` 생성자를 이용하여 디코딩 해야 한다.

```java
String str = new String(byte[] bytes, String charsetName);
```

<br/>
<br/>

## `substring()`

- 주어진 인덱스에서 문자열을 추출

```java
String example = "soshysocutecute";
String firstNum = example.substring(0, 6);
String secondNum = example.substring(7);
```

<br/>
<br/>

## `valueOf()`

- 기본 타입의 값을 문자열로 변환

```java
static String valueOf(boolean b)
static String valueOf(char c)
static String valueOf(int i)
static String valueOf(long l)
static String valueOf(double d)
static String valueOf(float f)
```
