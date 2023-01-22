# 4. List, LazyColumn

반복문을 이용하여 `List`를 만들 수 있다.

## Activity

```Kotlin
setContent {
//    val scrollState = rememberScrollState()
//    Column(
//        modifier = Modifier
//            .background(color = Color.DarkGray)
//            .fillMaxWidth()
//            .verticalScroll(scrollState)
//    ) {
//        for (i in 1..50) {
//            Text("Column $i")
//       }
//    }
    LazyColumn(
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            Text(text = "반복 시작")
        }
        items(50) {
            index -> Text("LazyColumn items $index")
        }
        item {
            Text(text = "종료")
        }
    }
}
```

- 주석처리된 `Column`의 경우 해당 방향으로 `Text` 요소를 반복하여 `List`처럼 보여지는 형태이다. 기본적으로 스크롤이 불가능하기 때문에 `scrollState = rememberScrollState()`와 같이 스크롤 기능의 변수를 선언하여 `modifier`의 `verticalScroll()` 속성에 할당하여 스크롤이 가능하게 해준다.
- 그 반면 `LazyColumn`의 경우 일반적으로 스크롤링이 가능하게 되어있고 많은 항목을 불러올때 주석처리된 방식보다 최적화의 측면에서 더 좋은 구현 방식이다. 따라서 대부분의 `List`들은 `LazyColumn`을 사용하는 것이 좋다.
  `Kotlin`의 `ListView`와 `RecyclerView` 정도의 차이라고 생각하면 된다.
