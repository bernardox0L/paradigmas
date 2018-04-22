import Data.Char

isVowel :: Char -> Bool
isVowel x = if(x=='a'||x=='A'||x=='e'||x=='E'||x=='i'||x=='I'||x=='o'||x=='O'||x=='u'||x=='U' ) then True else False

addComma :: [String]->[String]
addComma x= map(\y -> y++",")x

htmlListItems :: [String] -> [String]
htmlListItems x = map(\y -> "<LI>"++y++"</LI>")x

semVogais :: String -> String
semVogais x = filter isNotVowel x

isNotVowel :: Char->Bool
isNotVowel x= isVowel x == False

semVogaisAnon :: String->String
semVogaisAnon x = filter(\y->isVowel y==False)x

codificaAnon :: String -> String 
codificaAnon x = map(\y-> if y==' ' then ' ' else '-')x

codifica :: String -> String
codifica x = map trocaLetra x

trocaLetra :: Char -> Char
trocaLetra x= if x==' ' then ' ' else '-'

firstName :: String -> String
firstName x = takeWhile(/=' ')x

isInt :: String -> Bool
isInt x = length (filter (\y -> y > '9' || y < '0') x) == 0

lastName :: String -> String
lastName x = dropWhile(/=' ')x

userName :: String -> String
userName x = map toLower([head (firstName x)] ++ lastName x)

encodeName :: String -> String
encodeName x= map(\y-> if y=='a' then '4')x