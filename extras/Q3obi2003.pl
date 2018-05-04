% OBI 2003. ROLAND GARROS. No torneio de Roland Garros, um dos mais tradicionais torneios de tênis do mundo, realizado em
% Paris, participam 128 tenistas. Em cada partida, participam dois jogadores, sendo que o vencedor
% passa para a próxima fase, e o perdedor é eliminado do torneio. A cada rodada, os tenistas que
% ainda continuam no torneio participam de exatamente uma partida.

nPartidas(Times, Partidas):-
    Partidas is (Times-1).

% 3. Qual o número total de partidas deste torneio?
% (A) 64
% (B) 65
% (C) 127 <- nPartidas(128,X).
% (D) 128
% (E) nenhuma das acima