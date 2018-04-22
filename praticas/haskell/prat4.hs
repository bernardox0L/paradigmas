geraTabela :: Int -> [(Int,Int)]
geraTabela 0 = []
geraTabela n = (n,n*n):(geraTabela(n-1))

contido :: Char -> String -> Bool
contido c []= False
contido c (x:xs) = if(c==x) then True else contido c xs

translate :: [(Float,Float)]-> [(Float,Float)]
translate [] = []
translate (x:xs) = (fst x+2.0,snd x+2.0) : translate xs

geraTabela2 :: Int -> Int -> [(Int,Int)]
geraTabela2 0 c = []
geraTabela2 n c = (n,n*n):if(c==n)(geraTabela(n+1) c)geraTabela :: Int -> [(Int,Int)]
geraTabela 0 = []
geraTabela n = (n,n*n):(geraTabela(n-1))

contido :: Char -> String -> Bool
contido c []= False
contido c (x:xs) = if(c==x) then True else contido c xs

translate :: [(Float,Float)]-> [(Float,Float)]
translate [] = []
translate (x:xs) = (fst x+2.0,snd x+2.0) : translate xs

geraTabela2 :: Int -> Int -> [(Int,Int)]
geraTabela2 0 c = []
geraTabela2 n c = (n,n*n):if(c==n)(geraTabela(n+1) c)