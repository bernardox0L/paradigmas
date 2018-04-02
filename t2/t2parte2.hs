import Data.Char

 -- Questão 1: 
alternativeLength :: String -> Int
alternativeLength [] = 0
alternativeLength x = 1 + (alternativeLength $ tail x)
 
isCharBin :: Char -> Bool
isCharBin x = x == '0' || x == '1'

isBin :: String -> Bool
isBin [] = False
isBin x = if (alternativeLength x == 1) then isCharBin (head x) else isCharBin (head x) && isBin (tail x)
 
 
 -- Questão 2: 
isBin' :: String -> Bool
isBin' x = length(filter (\y -> not $ isCharBin y) x) == 0
 
 -- Questão 3: 
bin2dec :: [Int] -> Int
bin2dec [] = 0
bin2dec x = auxBin2Dec x ((length x)-1)

auxBin2Dec :: [Int] -> Int -> Int
auxBin2Dec [] y = 0
auxBin2Dec (x:xs) y = x * (2 ^ y) + auxBin2Dec xs (y - 1)
 
 -- Questão 4: 
bin2dec' :: [Int] -> Int
bin2dec' x = sum (zipWith (*) x (map (\y -> 2 ^ y) [(length x)-1, (length x)-2..0]))
 
 -- Questão 5: 
dec2binAux :: Int -> [Int]
dec2binAux 0 = []
dec2binAux x = mod x 2 : dec2binAux (div x 2)

dec2bin :: Int -> [Int]
dec2bin x = reverse $ dec2binAux x
 
  -- Questão 6: 
isCharHex :: Char -> Bool
isCharHex x = elem (toLower x) "123456789abcdef"
 
isHex :: String -> Bool
isHex x = length(filter (\y -> not $ isCharHex y) x) == 0

