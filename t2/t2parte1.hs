geraTabela :: Int -> [(Int,Int)]
geraTabela 0 = []
geraTabela n = (n,n*n):(geraTabela(n-1))

contido :: Char -> String -> Bool
contido c []= False
contido c (x:xs) = if(c==x) then True else contido c xs

translate :: [(Float,Float)]-> [(Float,Float)]
translate [] = []
translate (x:xs) = (fst x+2.0,snd x+2.0) : translate xs

geraTabela2 :: Int -> [(Int,Int)]
geraTabela2 0 = []
geraTabela2 x = reverse (geraTabela x)

aux :: Int -> Int -> [(Int,Int)]
aux n x = if (x>n) then [] else (x, x^2) : aux n (x+1)

geraTabela3 :: Int -> [(Int,Int)]
geraTabela3 x = if (x<1) then [] else aux x 1

