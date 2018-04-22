addSuffix :: String -> [String] -> [String]
addSuffix c lista = [n++c | n <- lista]

countShorts :: [String] -> Int
countShorts list = length[x | x <- list, (length x)< 5]