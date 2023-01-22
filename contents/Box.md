# 3. Box

요소를 다른 요소 위에 놓기 위해 `Box`를 사용한다.

## Activity

MainActivity.kt

```Kotlin
setContent {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column() {
            Text("Hi!", modifier = Modifier.padding(16.dp))
            Box(modifier = Modifier
                .background(color = Color.Black)
                .padding(16.dp)
                .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text("Cholee", color = Color.White)
            }
            Box(modifier = Modifier
                .background(color = Color.Blue)
                .padding(16.dp)
                .fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text("Bye!")
            }
        }
    }
}
```

- 상위 `Box`안에 `Column`을 사용하여 두 개의 다른 `Box`를 배치한 예제이다.
