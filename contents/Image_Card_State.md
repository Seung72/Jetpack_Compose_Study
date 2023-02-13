# 5. Image, Card, State

- `Card()`는 하나의 컨텐츠와 그와 관련된 내용과 작업이 포함하는 요소이다.
- `Image()`를 사용하여 원하는 이미지를 사용할 수 있다.
- `remember`를 사용하여 특정 변수를 유지할 수 있다.
- `rememberSaveable`을 사용하여 특정 변수를 유지하고,`Activity`가 재생성 되는 경우에도 불러올 수 있다(단, `Destroy`, `finish()`는 해당하지 않는다).
- `Icon()`으로 기본적으로 제공되는 일부 아이콘들을 불러와 사용할 수 있다.

## Acticity

MainActivity.kt

```Kotlin
// by remember를 사용하려면 아래와 같이 getValue를 import한다.
// remember를 사용한 변수에 바로 접근하기 위해서 setValue를 import한다.
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 이미지 1에 대한 Boolean 변수
            var isFavoriteB1 by rememberSaveable {
                mutableStateOf(false)
            }
            // 이미지 2에 대한 Boolean 변수
            var isFavoriteB2 by rememberSaveable {
                mutableStateOf(false)
            }
            Column() {
                ImageCard(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(16.dp),
                    isFavorite = isFavoriteB1,
                    R.drawable.book1
                ) {
                        favorite ->
                    isFavoriteB1 = favorite
                }
                ImageCard(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(16.dp),
                    isFavorite = isFavoriteB2,
                    R.drawable.book2
                ) {
                        favorite ->
                    isFavoriteB2 = favorite
                }
            }
        }
    }
}

@Composable
fun ImageCard(
    // 재사용성을 높이기 위해 Modifier, 이미지 주소를 인자로 전달한다.
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    image: Int,
    // Callback 함수를 사용하여 상태를 반환하고 불러온다.
    onTabFavorite: (Boolean) -> Unit) {

    Card(
        // 전달 받은 modifier 사용
        modifier = modifier,
        // 모서리 지정
        shape = RoundedCornerShape(8.dp),
        // 구분감을 주기 위한 그림자 효과
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp)
            ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = image),
                contentDescription = "book",
                contentScale = ContentScale.Crop
            )
            // 하트버튼을 생성하기 위해 기존 Box와 같은 크기의 Box 선언
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd,) {
                IconButton(onClick = {
                    onTabFavorite(!isFavorite)
                }) {
                    Icon(
                        // State 상태로 아이콘 상태 변경
                        imageVector = if(isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = Color.White)
                }
            }
        }
    }
}
```
