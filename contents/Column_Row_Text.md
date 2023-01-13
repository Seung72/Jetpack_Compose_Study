# 1. Column, Row, Text

## Column, Row

`Column`과 `Row`함수를 사용하여 요소를 각각 수직 / 수평으로 정렬할 수 있다.

#### Activity

MainActivity.kt

```Kotlin
...
setContent {
    Column_row_textTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Hello, ")
                    Text(text = "Android!")
                }
            }
        }
    }
}
...
```

- `Surface`안에 `Colomn`과 그 내부에 `Row`를 선언하고 `Text`요소를 추가한 코드이다.
- `Modifier`는 요소들의 크기나 `Padding` 및 `Margin`과 같은 속성과 `Background` 속성을 사용할 수 있다.
- `Alignment` 정렬 객체를 선언하여 `CenterHorizonTally`, `CenterVertically`등의 정렬 속성을 사용할 수 있다.
