import Data.Char

--(1)
isVowel :: Char -> Bool
isVowel x = if(x=='a'||x=='A'||x=='e'||x=='E'||x=='i'||x=='I'||x=='o'||x=='O'||x=='u'||x=='U' ) then True else False

--(2)
addComma :: [String] -> [String]
addComma x = map (\y -> y ++ ",") x

--(3) Sem função anônima
html :: String -> String
html x = "<LI>"++ x ++"</LI>"

htmlListItems :: [String] -> [String]
htmlListItems x = map html x

--(3) Com função anônima
htmlListItemsAnon :: [String] -> [String]
htmlListItemsAnon x = map (\y -> "<LI>" ++ y ++ "</LI>") x

--(4) Sem função anônima
isNotVowel :: Char -> Bool
isNotVowel x = isVowel x == False

semVogais :: String -> String
semVogais x = filter isNotVowel x

--(4) Com função anônima
isNotVowelAnon :: String -> String
isNotVowelAnon x = filter (\y -> isVowel y == False) x

--(5) Sem função anônima
trocaLetra :: Char -> Char
trocaLetra x = if x == ' ' then ' ' else '-'

trocaLetras :: String -> String
trocaLetras x = map trocaLetra x

--(5) Com função anônima
trocaLetraAnon :: String -> String
trocaLetraAnon x = map (\y -> if t == ' ' then ' ' else '-') x

--(6)
firstName :: String -> String
firstName x = takeWhile (/= ' ') x

--(7)
isInt :: String -> Bool
isInt x = length (filter (\y -> y > '9' || y < '0') x) == 0

--(8)
lastName :: String -> String
lastName x = reverse (firstName (reverse x))

--(9)
userName :: String -> String
userName x = map toLower ([head (firstName x)] ++ (lastName x))

--(10)
valorVogal :: Char -> Char
valorVogal x
  | x == 'a' = '4'
  | x == 'e' = '3'
  | x == 'i' = '2'
  | x == 'o' = '1'
  | x == 'u' = '0'

encodeName :: String -> String
encodeName x = map (\y -> if (isVowel y) then (valorVogal y) else y) x

--(11)

--(12)
