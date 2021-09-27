import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Locale;

import javafx.util.converter.LocalDateTimeStringConverter;
import javafx.util.converter.LocalTimeStringConverter;

public class SimulationClock {
	private LocalDateTime startingTime;

	public SimulationClock(LocalDateTime startingTime) {
		this.startingTime = startingTime;
	}

	public LocalDateTime getCurrentTime() {
		return LocalDateTime.now();
	}

	public void advanceTime(Duration duration) {
		startingTime.plus(duration);
	}

	public Duration getElapsedTime() {
		return Duration.between(getCurrentTime(), startingTime).abs();
	}

	public static void main(String[] args) {
		// output will be different on different machines
		LocalDateTime startTime = LocalDateTime.of(2003, 3, 23, 1, 3, 34);
		SimulationClock clock = new SimulationClock(startTime);
		System.out.println(clock.getCurrentTime());
		clock.advanceTime(Duration.ofDays(15));
		System.out.println(clock.getCurrentTime());
		clock.advanceTime(Duration.ofHours(10));
		System.out.println(clock.getCurrentTime());
		System.out.println(clock.getElapsedTime());

	}
}
