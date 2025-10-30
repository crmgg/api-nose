package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CountryEntity;

import java.util.ArrayList;
import java.util.List;

public final class CountryEntityAssembler implements EntityAssembler<CountryEntity, CountryDomain> {

    private static final EntityAssembler<CountryEntity,CountryDomain> instance =
            new CountryEntityAssembler();

    private CountryEntityAssembler() {

    }
    public static EntityAssembler<CountryEntity,CountryDomain> getCountryEntityAssembler() {
        return instance;
    }

    @Override
    public CountryEntity toEntity(final CountryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new CountryEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public CountryDomain toDomain(final CountryEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new CountryEntity());
        return new CountryDomain(entityTmp.getId(), entityTmp.getName());
    }

    @Override
    public List<CountryEntity> toEntity(List<CountryDomain> domainList) {
        var domainListTmp = ObjectHelper.getDefault(domainList, new ArrayList<CountryDomain>());
        var entityList = new ArrayList<CountryEntity>();

        for (var domain : domainListTmp) {
            entityList.add(toEntity(domain));
        }

        return entityList;
        }
    }