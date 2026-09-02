package energy.trolie.client.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration of the possible origins of a rating value, as reported by a
 * ratings provider on a rating proposal. Preserves the provenance or quality
 * of a rating value at the point of submission, distinguishing ratings that
 * arose from sensor/calculation failures from those derived normally.
 */
public enum CurrentSource {

    /**
     * The rating value was derived directly from telemetered sensor data.
     */
    TELEMETERED,

    /**
     * The rating value was derived from a calculation, such as a weather-based
     * or dynamic rating calculation.
     */
    CALCULATED,

    /**
     * The rating value was estimated, typically as a fallback when telemetry
     * or calculation inputs were unavailable or failed.
     */
    ESTIMATED,

    /**
     * The rating value was manually entered or overridden by an operator.
     */
    MANUAL;

    /**
     * @return the lower-case value used to represent this current-source in JSON.
     */
    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }

    /**
     * Resolves a {@link CurrentSource} from its JSON representation.
     * @param value the JSON string value
     * @return the matching {@link CurrentSource}
     */
    @JsonCreator
    public static CurrentSource fromJson(String value) {
        return value == null ? null : CurrentSource.valueOf(value.toUpperCase());
    }
}
