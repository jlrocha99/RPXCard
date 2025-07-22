package main.java.com.rpxcard.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

//Método de validação dos inputs refatorado
public class inputValidator {
  public static boolean isValidId(String id) {
    Pattern ID_PATTERN = Pattern.compile("\\d{6}");
    return id != null && ID_PATTERN.matcher(id).matches(); //true
  }
  public static boolean isValidName(String name) {
    Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\p{L}'\\\\s]+ [a-zA-Z\\p{L}'\\\\s]+$");
    return name != null && NAME_PATTERN.matcher(name).matches();
  }

  public static boolean isValidCpf(String cpf) {
    Pattern CPF_PATTERN = Pattern.compile("^[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-?[0-9]{2}");
    return cpf != null && CPF_PATTERN.matcher(cpf).matches();
  }

  public static boolean isValidEmail(String email) {
    Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    return email != null && EMAIL_PATTERN.matcher(email).matches();
  }

  public static boolean isValidBirthDate(String date) {
    Pattern BIRTH_DATE_PATTERN = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$");
    if (!BIRTH_DATE_PATTERN.matcher(date).matches()) {
      return false;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    try {
      LocalDate.parse(date, formatter);
      return true;
    } catch (DateTimeParseException dtpe) {
      return false;
    }
  }
}
