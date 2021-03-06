import Data.Char

-- Converte um caracter em um inteiro
encodeChar :: Char -> Int
encodeChar c = ord c - ord 'a'

-- Converte um inteiro em um caracter
decodeChar :: Int -> Char
decodeChar n = chr (ord 'a' + n)

-- Calcula percentagem: n/m*100
percent :: Int -> Int -> Float
percent n m = (fromIntegral n / fromIntegral m)*100

-- Rotacao de uma lista para esquerda em n posicoes
rotate :: Int -> [a] -> [a]
rotate n xs = drop n xs ++ take n xs

-- Tabela de frequencias das letras 'a'..'z' (lingua portuguesa)
-- https://pt.wikipedia.org/wiki/Frequ%C3%AAncia_de_letras
table :: [Float]
table = [14.6, 1.0, 3.9, 5.0, 12.6, 1.0, 1.3, 1.3, 6.2, 0.4, 0.1, 2.8, 4.7, 
         5.0, 10.7, 2.5, 1.2, 6.5, 7.8, 4.3, 4.6, 1.7, 0.1, 0.2, 0.1, 0.5]

-- Distancia entre 2 listas de frequencia
chi2 :: [Float] -> [Float] -> Float
chi2 os es = sum [((o-e)^2)/e | (o,e) <- zip os es]

-- Use esta funcao para decodificar uma mensagem!
crack :: String -> String
crack cs = encodeStr cs (-factor)
           where factor = head (positions (minimum chitab) chitab)
                 chitab = [ chi2 (rotate n table' ) table | n <- [0..25] ]
                 table' = freqs cs

-- Quest�o 1 
shiftChar :: Char -> Int -> Char
shiftChar x y = decodeChar (mod ((encodeChar x) + y) 26)

-- Quest�o 2
encodeStr :: String -> Int -> String
encodeStr x y = map (\z -> shiftChar z y) x

-- Quest�o 3
countValids :: String -> Int
countValids x = length (filter isLower x)

-- Quest�o 4
countChar :: Char -> String -> Int
countChar x y = length (filter (== x) y)

-- Quest�o 5
freqs :: String -> [Float]
freqs x = [percent (countChar y x) (countValids x) | y <- ['a'..'z'] ]

-- Quest�o 6

positions :: Float -> [Float] -> [Int]
positions x y = map snd $ filter (\z-> fst z == x) (zip y [0..])