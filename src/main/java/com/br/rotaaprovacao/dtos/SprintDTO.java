package com.br.rotaaprovacao.dtos;

import java.time.LocalDate;

public record SprintDTO (Long userId, LocalDate startDate, LocalDate endDate, String goal){
}
