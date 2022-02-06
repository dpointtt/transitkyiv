package ua.com.transitkyiv.transitkyiv.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.transitkyiv.transitkyiv.entity.Routes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ExtendedRoutesRepositoryImpl implements ExtendedRoutesRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Routes> findFromToTran(String fromAddress, String toAddress, String transport) {
        Query query = entityManager.createQuery(
                "select rt from Routes rt " +
                "join rt.routeStopsList rsl " +
                "join rsl.stop_ st " +
                "join rt.transports_ tr " +
                "where st.stopAddress in (:addresses) " +
                "and tr.transport in (:tran) " +
                "group by rt.routeNumber " +
                "having COUNT(rt) > 1", Routes.class);
        List<String> fromToParams = Arrays.asList(fromAddress, toAddress);
        List<Routes> fromToTransportResult = query.setParameter("addresses", fromToParams).setParameter("tran", transport).getResultList();
        return fromToTransportResult;
    }

    @Override
    public List<Routes> findFromTo(String fromAddress, String toAddress) {
        Query query = entityManager.createQuery(
                "select rt from Routes rt " +
                        "join rt.routeStopsList rsl " +
                        "join rsl.stop_ st " +
                        "join rt.transports_ tr " +
                        "where st.stopAddress in (?1) " +
                        "group by rt.routeNumber " +
                        "having COUNT(rt) > 1", Routes.class);
        List<String> fromToParams = Arrays.asList(fromAddress, toAddress);
        List<Routes> fromToResult = query.setParameter(1, fromToParams).getResultList();
        return fromToResult;
    }

    @Override
    public List<Routes> findRoutesTransports(String transport) {
        Query query = entityManager.createQuery(
                "select rt from Routes rt " +
                        "join rt.transports_ tr " +
                        "where tr.transport in (?1) ", Routes.class);
        List<Routes> routesTransportsResult = query.setParameter(1, transport).getResultList();
        return routesTransportsResult;
    }
}
