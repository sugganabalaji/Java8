package com.LocalDate.Example1;

import java.time.LocalDate;

public record Company(String name,
                      String role,
                      LocalDate startDate,
                      LocalDate endDate) {
}
