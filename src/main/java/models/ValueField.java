package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ValueField {
    String value;
    Timestamp currentTimestamp;
    Timestamp entryTimestamp;
}
