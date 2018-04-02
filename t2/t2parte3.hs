import Data.Char

isEanOk :: String -> Bool
isEanOk x = if (length(x) /= 13) then False else ean x

ean :: String -> Bool
ean x = if ((fazDigito (init (x)) == ord (last (str)) - ord ('0')) && length(filter (\y -> y >= '0' && y <= '9') x) == length(x)) then True else False

fazDigito :: String -> Int
fazDigito x = 10 - (sum $ zipWith (*) fazLista x [1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3]) `mod` 10

fazLista :: String -> [Int]
fazLista "" = []
fazLista (x:xs) = ord (x) - ord ('0') : fazLista xs