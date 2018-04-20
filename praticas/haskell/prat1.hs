somaQuad :: Int -> Int -> Int
somaQuad x y = x*x + y*y

hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads x y = if(head x == head y) then True else False

addSuper :: [String]->[String]
addSuper x = map (\y -> "Super"++ y) x

numSpaces :: String->Int
numSpaces x= length(filter (\y -> y ==' ')x)

makeEq :: [Double]->[Double]
makeEq x = map(\y ->  3*y^2 + 2/y + 1 )x 

mostNeg :: [Int]->[Int]
mostNeg x = filter(\y-> y<0)x

entreDois :: [Int]->[Int]
entreDois x = filter(\y-> y<=100 && y>=1)x

maisNovos :: [Int]->[Int]
maisNovos x= filter(\y-> (2018-y)>=1980)x

numPares :: [Int]->[Int]
numPares x = filter(\y ->  mod y 2==0)x

charFound :: Char -> String -> Bool
charFound c str = if length(filter(\y->y==c)str)>0 then True else False

finalA :: [String]->[String]
finalA x = filter(\y-> last y=='a')x