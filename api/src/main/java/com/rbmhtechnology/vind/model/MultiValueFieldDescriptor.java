package com.rbmhtechnology.vind.model;

import com.rbmhtechnology.vind.api.Document;
import com.rbmhtechnology.vind.api.query.datemath.DateMathExpression;
import com.rbmhtechnology.vind.api.query.filter.Filter;
import com.rbmhtechnology.vind.model.value.LatLng;

import java.nio.ByteBuffer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;

import static com.rbmhtechnology.vind.api.query.filter.Filter.*;
import static com.rbmhtechnology.vind.api.query.filter.Filter.eq;

/**
 * Abstract class t be implemented by the fields meant to be multi-valued.
 * Created by fonso on 6/24/16.
 */
public abstract class MultiValueFieldDescriptor<T> extends FieldDescriptor<T> {

    protected MultiValueFieldDescriptor(String fieldName, Class<T> type) {
        super(fieldName, type);
        this.sort = false;
    }

    public Function<Collection<T>, T> getsortFunction() {
        return (Function<Collection<T>, T>)this.sortFunction;
    }
    /**
     * Class to instantiate fields containing multiple numeric values.
     *
     * @param <T> specific field type, must extend {@link Number}.
     */
    public static class NumericFieldDescriptor<T extends Number> extends MultiValueFieldDescriptor<T> {

        protected NumericFieldDescriptor(String fieldName, Class<T> type) {
            super(fieldName, type);
        }
        /**
         * Instantiates a new {@link Filter} to checking if the field value is between two numbers.
         * @param start Lower number on the filter range check.
         * @param end Greater number in the filter range check.
         * @return A configured filter for the field.
         */
        public Filter between(Number start, Number end) {
            return Filter.between(this.getName(), start, end);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is greater than a numbers.
         * @param number Number to check against.
         * @return A configured filter for the field.
         */
        public Filter greaterThan(Number number) {
            return Filter.greaterThan(this.getName(), number);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is lower than a numbers.
         * @param number Number to check against.
         * @return A configured filter for the field.
         */
        public Filter lesserThan(Number number) {
            return Filter.lesserThan(this.getName(), number);
        }

    }

    /**
     * Class to instantiate {@link Document} fields containing multiple date value.
     *
     * @param <T> specific field type, must extend {@link ZonedDateTime}
     */
    public static class DateFieldDescriptor<T extends ZonedDateTime> extends MultiValueFieldDescriptor<T> {

        protected DateFieldDescriptor(String fieldName, Class<T> type) {
            super(fieldName, type);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is between two dates.
         * @param start Earliest date on the filter range check.
         * @param end Latest date in the filter range check.
         * @return A configured filter for the field.
         */
        public Filter between(ZonedDateTime start, ZonedDateTime end) {
            return Filter.between(this.getName(), start, end);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is between two points in time.
         * @param start Earliest {@link DateMathExpression} on the filter range check.
         * @param end Latest {@link DateMathExpression} in the filter range check.
         * @return A configured filter for the field.
         */
        public Filter between(DateMathExpression start, DateMathExpression end) {
            return Filter.between(this.getName(), start, end);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is between two dates.
         * @param start Earliest date on the filter range check.
         * @param end Latest date in the filter range check.
         * @return A configured filter for the field.
         */
        public Filter between(Date start, Date end) {
            return Filter.between(this.getName(), ZonedDateTime.ofInstant(start.toInstant(), ZoneId.of("UTC")), ZonedDateTime.ofInstant(end.toInstant(), ZoneId.of("UTC")));
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is before a date.
         * @param date {@link DateMathExpression} to check against.
         * @return A configured filter for the field.
         */
        public Filter before(DateMathExpression date) {
            return Filter.before(this.getName(), date);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is before a date.
         * @param date Date to check against.
         * @return A configured filter for the field.
         */
        public Filter before(ZonedDateTime date) {
            return Filter.before(this.getName(), date);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is before a date.
         * @param date Date to check against.
         * @return A configured filter for the field.
         */
        public Filter before(Date date) {
            return Filter.before(this.getName(), ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")));
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is after a date.
         * @param date Date to check against.
         * @return A configured filter for the field.
         */
        public Filter after(ZonedDateTime date) {
            return Filter.after(this.getName(), date);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is after a date.
         * @param date {@link DateMathExpression} to check against.
         * @return A configured filter for the field.
         */
        public Filter after(DateMathExpression date) {
            return Filter.after(this.getName(), date);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is after a date.
         * @param date Date to check against.
         * @return A configured filter for the field.
         */
        public Filter after(Date date) {
            return Filter.after(this.getName(), ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")));
        }
    }

    /**
     * Class to instantiate {@link Document} fields containing multiple date value.
     *
     * @param <T> The field content type, must extend java.util.Date.
     */
    public static class UtilDateFieldDescriptor<T extends Date> extends MultiValueFieldDescriptor<T> {

        protected UtilDateFieldDescriptor(String fieldName, Class<T> type) {
            super(fieldName, type);
        }
        /**
         * Instantiates a new {@link Filter} to checking if the field value is between two dates.
         * @param start Earliest date on the filter range check.
         * @param end Latest date in the filter range check.
         * @return A configured filter for the field.
         */
        public Filter between(ZonedDateTime start, ZonedDateTime end) {
            return Filter.between(this.getName(), start, end, Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is between two points in time.
         * @param start Earliest {@link DateMathExpression} on the filter range check.
         * @param end Latest {@link DateMathExpression} in the filter range check.
         * @return A configured filter for the field.
         */
        public Filter between(DateMathExpression start, DateMathExpression end) {
            return Filter.between(this.getName(), start, end, Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is between two dates.
         * @param start Earliest date on the filter range check.
         * @param end Latest date in the filter range check.
         * @return A configured filter for the field.
         */
        public Filter between(Date start, Date end) {
            return Filter.between(this.getName(), ZonedDateTime.ofInstant(start.toInstant(), ZoneId.of("UTC")), ZonedDateTime.ofInstant(end.toInstant(), ZoneId.of("UTC")), Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is before a date.
         * @param date {@link DateMathExpression} to check against.
         * @return A configured filter for the field.
         */
        public Filter before(DateMathExpression date) {
            return Filter.before(this.getName(), date, Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is before a date.
         * @param date Date to check against.
         * @return A configured filter for the field.
         */
        public Filter before(ZonedDateTime date) {
            return Filter.before(this.getName(), date, Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is before a date.
         * @param date Date to check against.
         * @return A configured filter for the field.
         */
        public Filter before(Date date) {
            return Filter.before(this.getName(),ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")), Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is after a date.
         * @param date Date to check against.
         * @return A configured filter for the field.
         */
        public Filter after(ZonedDateTime date) {
            return Filter.after(this.getName(), date, Scope.Facet);
        }


        /**
         * Instantiates a new {@link Filter} to checking if the field value is after a date.
         * @param date {@link DateMathExpression} to check against.
         * @return A configured filter for the field.
         */
        public Filter after(DateMathExpression date) {
            return Filter.after(this.getName(), date, Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is after a date.
         * @param date Date to check against.
         * @return A configured filter for the field.
         */
        public Filter after(Date date) {
            return Filter.after(this.getName(), ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")), Scope.Facet);
        }
    }

    /**
     * Class to instantiate {@link Document} fields containing multiple text values.
     *
     * @param <T> The field content type, must extend CharSequence.
     */
    public static class TextFieldDescriptor<T extends CharSequence> extends MultiValueFieldDescriptor<T> {

        protected TextFieldDescriptor(String fieldName, Class<T> type) {
            super(fieldName, type);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value is equals to a text.
         * @param text text to check against.
         * @return A configured filter for the field.
         */
        public Filter equals(String text) {
            return eq(this.getName(), text, Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if the field value has as prefix a text.
         * @param prefix text to check against.
         * @return A configured filter for the field.
         */
        public Filter prefix(String prefix) {
            return Filter.prefix(this.getName(), prefix);
        }
    }

    /**
     * Class to instantiate {@link Document} fields containing multiple location values.
     *
     * @param <T> The field content type, must extend LatLng.
     */
    public static class LocationFieldDescriptor<T extends LatLng> extends MultiValueFieldDescriptor<T> {

        protected LocationFieldDescriptor(String fieldName, Class<T> type) {
            super(fieldName, type);
        }

        /**
         * Instantiates a new {@link Filter} to checking if a field value is within a bounding box.
         *
         * @param upperLeft  the upper left corner of the box
         * @param lowerRight the lower left corner of the box
         * @return A configured filter for the field.
         */
        public Filter withinBBox(LatLng upperLeft, LatLng lowerRight) {
            return Filter.withinBBox(this.getName(), upperLeft, lowerRight);
        }

        /**
         * Instantiates a new {@link Filter} to checking if a field value is within a circle.
         *
         * @param center   the of teh circle
         * @param distance the radius of the circle
         * @return A configured filter for the field.
         */
        public Filter withinCircle(LatLng center, double distance) {
            return Filter.withinCircle(this.getName(), center, distance);
        }

        /**
         * Instantiates a new {@link Filter} to checking if a field value is not empty.
         * @return A configured filter for the field.
         */
        public Filter isNotEmpty() {
            return new NotEmptyLocationFilter(this.getName(), Scope.Facet);
        }

        /**
         * Instantiates a new {@link Filter} to checking if a field value is empty.
         * @return A configured filter for the field.
         */
        public Filter isEmpty() {
            return new NotFilter( new NotEmptyLocationFilter(this.getName(), Scope.Facet));
        }
    }
    /**
     * Class to instantiate {@link Document} fields containing multiple binary field values.
     *
     * @param <T> The field content type, must extend ByteBuffer.
    */
    public static class BinaryFieldDescriptor<T extends ByteBuffer> extends SingleValueFieldDescriptor<T> {

        protected BinaryFieldDescriptor(String fieldName, Class<T> type) {
            super(fieldName, type);
        }

    }
}
