package com.br.rotaaprovacao.dtos;

public record StudySessionDTO (Long sprintId, Long subjectId, Integer durationMinutes, Integer questionsAnswered, Integer correctAnswers){
}
