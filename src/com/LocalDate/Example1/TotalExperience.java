package com.LocalDate.Example1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TotalExperience {

    public static void main(String[] args) {

        LocalDate educationCompleted = LocalDate.of(2014, Month.DECEMBER, 18);
        List<Company> companies = getCompanyList();
        Company company = companies.get(0);
        LocalDate firstJobStartDate = company.startDate();

        String s = calculateStudyJobGap(educationCompleted, firstJobStartDate);
        System.out.println(s);
        System.out.println("----------------------------------");

        //List<Company> companies = getCompanyList();
        String totalExperience = calculate(companies);
        System.out.println(totalExperience);
        System.out.println("----------------------------------");
    }

    private static List<Company> getCompanyList() {
        Company worklogix = new Company("Worklogix Management Solutions Pvt Ltd", "Developer", LocalDate.of(2016, 06, 27), LocalDate.of(2016, 12, 16));
        Company alchemy = new Company("Alchemy Techsol India Pvt Ltd", "Java Developer", LocalDate.of(2017, 04, 18), LocalDate.of(2017, 11, 30));
        Company bct = new Company("Bahwan CyberTek Pvt Ltd", "Software Engineer", LocalDate.of(2017, 12, 1), LocalDate.of(2020, 2, 7));
        Company cts = new Company("Cognizant Technology Solutions India Pvt Ltd", "Associate - Projects", LocalDate.of(2020, 2, 12), LocalDate.of(2021, 8, 9));
        Company altimetrik = new Company("Altimetrik India Pvt Ltd", "Senior Engineer – Product and Platform Engineering", LocalDate.of(2021, 8, 12), LocalDate.of(2025, 8, 1));
        Company cotiviti = new Company("Cotiviti India Private limited", "Senior Software Engineer", LocalDate.of(2025, 8, 25), LocalDate.of(2026, 3, 24));

        return List.of(
//                worklogix,
                alchemy, bct, cts, altimetrik, cotiviti);
    }

    private static String calculate(List<Company> companies) {
        long totalDays = 0;
        for (Company company : companies) {
            System.out.println(company.toString());
            LocalDate startDate = company.startDate();
            LocalDate endDate = company.endDate();

            Period period = Period.between(company.startDate(), company.endDate());
            System.out.println(period.getYears() + " Years,"+ period.getMonths() + " months," + period.getDays() + " days.");

            long days = ChronoUnit.DAYS.between(startDate, endDate);
            totalDays += days;

            System.out.println("days: " + days +",Total days: " + totalDays);
            System.out.println("----------------------------------");
        }

        long years = totalDays / 365;
        long months = (totalDays % 365) / 30;
        long days = (totalDays % 365) % 30;

        return "Total Experience: " + years + " years, " + months + " months, " + days + " days";
    }

    private static String calculateStudyJobGap(LocalDate educationCompleted, LocalDate firstJobStartDate) {
        if (educationCompleted == null || firstJobStartDate == null) {
            return "Invalid input dates";
        }
        // If job started before education completed, treat gap as 0
        if (firstJobStartDate.isBefore(educationCompleted)) {
            return "GAP: 0 years, 0 months, 0 days";
        }
        Period gap = Period.between(educationCompleted, firstJobStartDate);
        return "After Study GAP: " + gap.getYears() + " years, "
                + gap.getMonths() + " months, "
                + gap.getDays() + " days";
    }

}
