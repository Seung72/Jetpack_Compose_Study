# 2. Composable_Preview

## Composable

`Composable`는 `Compose`의 `setContents()`에서 작동되는 애플리케이션 빌딩 블록 함수이다.

```Kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```

일반 함수와 다른 점은 아래와 같다.

- `@Composable`을 함수 위에 명시해야 한다.
- [`UpperCamelCase`](https://wiki.c2.com/?UpperCamelCase)를 적용한다.
- 일반 함수와 다르게 UI를 선언할 수 있다.

## Preview

`@Preview`는 IDE에서 작성해놓은 코드를 Split 또는 Design의 미리보기 화면으로 확인할 수 있다.

```Kotlin
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    E02_Composable_PreviewTheme {
        Greeting("Android")
    }
}
```

함수로 구성된 UI 사용 시 미리보기 함수 내에 함수를 선언하면 된다.
