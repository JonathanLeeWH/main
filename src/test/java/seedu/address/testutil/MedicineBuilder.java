package seedu.address.testutil;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import seedu.address.model.medicine.Batch;
import seedu.address.model.medicine.BatchNumber;
import seedu.address.model.medicine.Company;
import seedu.address.model.medicine.Expiry;
import seedu.address.model.medicine.Medicine;
import seedu.address.model.medicine.Name;
import seedu.address.model.medicine.Quantity;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Medicine objects.
 */
public class MedicineBuilder {

    public static final String DEFAULT_NAME = "Paracetamol";
    public static final String DEFAULT_QUANTITY = "0";
    public static final String DEFAULT_EXPIRY = "-";
    public static final String DEFAULT_COMPANY = "GlaxoSmithKline";

    private Name name;
    private Quantity quantity;
    private Expiry expiry;
    private Company company;
    private Set<Tag> tags;
    private Map<BatchNumber, Batch> batches;

    public MedicineBuilder() {
        name = new Name(DEFAULT_NAME);
        quantity = new Quantity(DEFAULT_QUANTITY);
        expiry = new Expiry(DEFAULT_EXPIRY);
        company = new Company(DEFAULT_COMPANY);
        tags = new HashSet<>();
        batches = new HashMap<>();
    }

    /**
     * Initializes the MedicineBuilder with the data of {@code medicineToCopy}.
     */
    public MedicineBuilder(Medicine medicineToCopy) {
        name = medicineToCopy.getName();
        quantity = medicineToCopy.getQuantity();
        expiry = medicineToCopy.getExpiry();
        company = medicineToCopy.getCompany();
        tags = new HashSet<>(medicineToCopy.getTags());
        batches = new HashMap<>(medicineToCopy.getBatches());
    }

    /**
     * Sets the {@code Name} of the {@code Medicine} that we are building.
     */
    public MedicineBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Medicine} that we are building.
     */
    public MedicineBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Company} of the {@code Medicine} that we are building.
     */
    public MedicineBuilder withCompany(String company) {
        this.company = new Company(company);
        return this;
    }

    /**
     * Sets the {@code Quantity} of the {@code Medicine} that we are building.
     */
    public MedicineBuilder withQuantity(String quantity) {
        this.quantity = new Quantity(quantity);
        return this;
    }

    /**
     * Sets the {@code Expiry} of the {@code Medicine} that we are building.
     */
    public MedicineBuilder withExpiry(String expiry) {
        this.expiry = new Expiry(expiry);
        return this;
    }

    /**
     * Parses the {@code batchDetails} into a {@code Map<BatchName, Batch>} and set it to the {@code Medicine} that we are
     * building.
     */
    public MedicineBuilder withBatches(String ... batchDetails) {
        this.batches = SampleDataUtil.getBatchSet(batchDetails);
        return this;
    }

    public Medicine build() {
        return new Medicine(name, quantity, expiry, company, tags, Collections.emptyMap());
    }

}
