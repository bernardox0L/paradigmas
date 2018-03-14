isVowel :: Char -> Bool
isVowel x = if(x=='a'||x=='A'||x=='e'||x=='E'||x=='i'||x=='I'||x=='o'||x=='O'||x=='u'||x=='U' ) then True else False

addComma :: String -> String
addComma x = x++","

html :: String -> String
html x = "<LI>"++ x ++"</LI>"

htmlListItems :: [String] -> [String]
htmlListItems x = map html x

isNotVowel :: Char -> Bool
isNotVowel x = isVowel x == False

semVogais :: String -> String
semVogais x = filter isNotVowel x
